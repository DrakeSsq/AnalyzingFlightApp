package com.app.models.reports;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MonthlyReport {
    private String period;

    @JsonProperty("total_flight_time_hours")
    private double totalFlightTimeHours;

    @JsonProperty("violation_flags")
    private List<String> violationFlags;
}
