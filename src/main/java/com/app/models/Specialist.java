package com.app.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Month;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Specialist {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    private Map<Month, Double> monthlyHours = new HashMap<>();

    public void addFlightTime(Month month, double hours) {
        if (monthlyHours.containsKey(month)) {
            monthlyHours.put(month, monthlyHours.get(month) + hours);
        } else {
            monthlyHours.put(month, hours);
        }
    }
}
