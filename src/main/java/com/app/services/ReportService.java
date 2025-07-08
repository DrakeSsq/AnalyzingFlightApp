package com.app.services;

import com.app.models.AviationData;
import com.app.models.Specialist;
import com.app.models.reports.AviationReport;
import com.app.models.reports.MonthlyReport;
import com.app.models.reports.SpecialistReport;

import java.time.Month;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ReportService {

    public AviationReport generateReport(AviationData aviationData) {
        AviationReport aviationReport = new AviationReport();
        aviationReport.setSpecialistReports(createSpecialistReport(aviationData));
        return aviationReport;
    }

    private List<SpecialistReport> createSpecialistReport(AviationData aviationData) {
        List<SpecialistReport> specialistReports = new ArrayList<>();

        for (Specialist spec : aviationData.getSpecialists()) {
            SpecialistReport specialistReport = new SpecialistReport();
            specialistReport.setId(spec.getId());
            specialistReport.setName(spec.getName());

            specialistReport.setMonthlyReports(createMonthlyReport(aviationData, spec));

            specialistReports.add(specialistReport);
        }

        return specialistReports;
    }

    private List<MonthlyReport> createMonthlyReport(AviationData aviationData, Specialist spec) {
        List<MonthlyReport> monthlyReports = new ArrayList<>();

        for (Map.Entry<Month, Double> entry : spec.getMonthlyHours().entrySet()) {

            MonthlyReport monthlyReport = new MonthlyReport();
            monthlyReport.setPeriod(getReferenceYear(aviationData, entry));
            monthlyReport.setTotalFlightTimeHours(entry.getValue());
            monthlyReport.setViolationFlags(createViolations(entry, spec));
            monthlyReports.add(monthlyReport);
        }

        return monthlyReports;
    }

    private List<String> createViolations(Map.Entry<Month, Double> entry, Specialist spec) {

        List<String> violations = new ArrayList<>();

        if (spec.getMonthlyHoursViolation().getOrDefault(entry.getKey(), false)) {
            violations.add("MONTHLY_LIMIT_EXCEEDED");
        }
        if (spec.getWeeklyHoursViolations().getOrDefault(entry.getKey(), false)) {
            violations.add("WEEKLY_LIMIT_EXCEEDED");
        }
        if (spec.getDailyHoursViolation().getOrDefault(entry.getKey(), false)) {
            violations.add("DAILY_LIMIT_EXCEEDED");
        }

        return violations;
    }

    private String getReferenceYear(AviationData aviationData, Map.Entry<Month, Double> entry) {

        return Optional.ofNullable(aviationData.getFlights())
                .filter(flights -> !flights.isEmpty())
                .map(flights -> YearMonth.of(
                        flights.get(0).getLandingTimeUtc().getYear(),
                        entry.getKey().getValue()
                ).toString())
                .orElse("UNKNOWN-" + entry.getKey().getValue());
    }
}
