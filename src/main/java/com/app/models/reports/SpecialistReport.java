package com.app.models.reports;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
public class SpecialistReport {

    private Integer id;
    private String name;

    @JsonProperty("monthly_report")
    private List<MonthlyReport> monthlyReports;
}
