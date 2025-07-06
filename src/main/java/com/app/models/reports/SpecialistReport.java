package com.app.models.reports;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpecialistReport {

    private Integer id;
    private String name;

    @JsonProperty("monthly_report")
    private List<MonthlyReport> monthlyReports;
}
