package com.app.services;

import com.app.models.AviationData;
import com.app.models.Flight;
import com.app.models.Specialist;
import lombok.Getter;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.WeekFields;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Getter
public class TimeService {
    private final AviationData aviationData;

    public TimeService(AviationData aviationData) {
        this.aviationData = aviationData;
    }

    public void calculateTime() {
        for (Flight flight : aviationData.getFlights()) {
            Duration duration = Duration.between(flight.getTakeoffTimeUtc(), flight.getLandingTimeUtc());

            double hours = duration.toMinutes() / 60.0;

            Month month = flight.getLandingTimeUtc().getMonth();

            for (Integer specialistId : flight.getCrew()) {
                Specialist specialist = findSpecialistById(specialistId);
                if (specialist!=null) {
                    specialist.addFlightTime(month, hours);

                    checkDailyViolation(specialist, month, hours);
                }
            }

            checkWeeklyHoursViolation();
            checkMonthlyHoursViolation();
        }
    }

    private Specialist findSpecialistById(Integer specialistId) {
        return aviationData.getSpecialists()
                .stream()
                .filter(s -> s.getId().equals(specialistId))
                .findAny()
                .orElse(null);
    }

    private void checkMonthlyHoursViolation() {
        for (Specialist spec : aviationData.getSpecialists()) {

            for (Map.Entry<Month, Double> entry : spec.getMonthlyHours().entrySet()) {
                Month month = entry.getKey();
                double hours = entry.getValue();

                if (hours > 80) {
                    spec.getMonthlyHoursViolation().put(month, true);
                }
            }

        }
    }

    private void checkWeeklyHoursViolation() {
        for (Specialist spec : aviationData.getSpecialists()) {

            Map<Month, Map<Integer, Double>> monthWeekHours = new HashMap<>();

            for (Flight flight : aviationData.getFlights()) {

                if (flight.getCrew().contains(spec.getId())) {

                    LocalDateTime takeOff = flight.getTakeoffTimeUtc();

                    Month month = takeOff.getMonth();

                    int weekNumber = getWeekOfMonth(takeOff);
                    double hours = calculateFlightHours(flight);

                    monthWeekHours
                            .computeIfAbsent(month, k -> new HashMap<>())
                            .merge(weekNumber, hours, Double::sum);


                }
            }

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
