package com.app.models.reports;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AviationReport {

    @JsonProperty("aviation_report")
    private List<SpecialistReport> specialistReports;
}
