package com.app.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.Month;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Specialist {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    private Map<Month, Double> monthlyHours = new HashMap<>();

    private Map<Month, Boolean> monthlyHoursViolation = new HashMap<>();
    private Map<Month, Boolean> weeklyHoursViolations = new HashMap<>();
    private Map<Month, Boolean> dailyHoursViolation = new HashMap<>();

    public void addFlightTime(Month month, double hours) {
        monthlyHours.merge(month, hours, Double::sum);
    }
}
