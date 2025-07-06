package com.app.models.reports;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class AviationReport {

    @JsonProperty("aviation_report")
    private List<SpecialistReport> specialistReports;
}
