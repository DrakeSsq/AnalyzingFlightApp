package com.app.services;

import com.app.models.AviationData;
import com.app.models.Flight;
import com.app.models.Specialist;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.WeekFields;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class TimeService {

    public void calculateTime(AviationData aviationData) {

        aviationData.getFlights().forEach(flight -> {
                 Duration duration = Duration.between(flight.getTakeoffTimeUtc(), flight.getLandingTimeUtc());

                 double hours = duration.toMinutes() / 60.0;
                 Month month = flight.getLandingTimeUtc().getMonth();
                 updateSpecialistsFlightTime(flight, aviationData, month, hours);

                 checkWeeklyHoursViolation(aviationData);
                 checkMonthlyHoursViolation(aviationData);
                });
    }

    private void updateSpecialistsFlightTime(Flight flight, AviationData aviationData, Month month, double hours) {
        flight.getCrew().stream()
                .map(specialistId -> findSpecialistById(specialistId, aviationData))
                .forEach(specialist -> {
                    specialist.addFlightTime(month, hours);
                    checkDailyViolation(specialist, month, hours);
                });
    }

    private Specialist findSpecialistById(Integer specialistId, AviationData aviationData) {
        return aviationData.getSpecialists()
                .stream()
                .filter(s -> s.getId().equals(specialistId))
                .findAny()
                .orElse(null);
    }

    private void checkMonthlyHoursViolation(AviationData aviationData) {
        aviationData.getSpecialists()
                .forEach(specialist ->
                        specialist.getMonthlyHours().entrySet().stream()
                .filter(entry -> entry.getValue()>80)
                        .forEach(entry ->
                                specialist.getMonthlyHoursViolation().put(entry.getKey(), true)));

    }

    private void checkWeeklyHoursViolation(AviationData aviationData) {
        for (Specialist spec : aviationData.getSpecialists()) {

            Map<Month, Map<Integer, Double>> monthWeekHours = new HashMap<>();

            aviationData.getFlights().stream()
                    .filter(flight -> flight.getCrew().contains(spec.getId()))
                    .forEach(flight -> {
                        LocalDateTime takeOff = flight.getTakeoffTimeUtc();

                        Month month = takeOff.getMonth();
                        int weekNumber = getWeekOfMonth(takeOff);
                        double hours = calculateFlightHours(flight);

                        monthWeekHours
                                .computeIfAbsent(month, k -> new HashMap<>())
                                .merge(weekNumber, hours, Double::sum);
                    });

            for (Map.Entry<Month, Map<Integer, Double>> monthEntry : monthWeekHours.entrySet()) {
                boolean hasViolation = monthEntry.getValue().values()
                        .stream()
                        .anyMatch(weekHours -> weekHours > 36);

                if (hasViolation) {
                    spec.getWeeklyHoursViolations().put(monthEntry.getKey(), true);
                }
            }
        }
    }

    private void checkDailyViolation(Specialist spec, Month month, double hours) {
        if (hours > 8) {
            spec.getDailyHoursViolation().put(month, true);
        }
    }

    private double calculateFlightHours(Flight flight) {
        return Duration.between(flight.getTakeoffTimeUtc(), flight.getLandingTimeUtc())
                .toMinutes() / 60.0;
    }

    private int getWeekOfMonth(LocalDateTime date) {
        LocalDate localDate = date.toLocalDate();
        return localDate.get(WeekFields.of(Locale.getDefault()).weekOfMonth());
    }
}
