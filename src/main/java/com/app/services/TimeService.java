package com.app.services;

import com.app.models.AviationData;
import com.app.models.Flight;
import com.app.models.Specialist;

import java.time.Duration;
import java.time.Month;

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
                }
            }
        }
    }

    private Specialist findSpecialistById(Integer specialistId) {
        return aviationData.getSpecialists()
                .stream()
                .filter(s -> s.getId().equals(specialistId))
                .findAny()
                .orElse(null);
    }
}
