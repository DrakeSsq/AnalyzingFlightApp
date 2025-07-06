package com.app.services;

import com.app.models.AviationData;
import com.app.models.Specialist;
import com.app.models.reports.AviationReport;
import com.app.models.reports.MonthlyReport;
import com.app.models.reports.SpecialistReport;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.Month;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportService {

    private final TimeService timeService;

    public ReportService(TimeService timeService) {
        this.timeService = timeService;

    }

    public AviationReport generateReport() {
        AviationReport aviationReport = new AviationReport();
        List<SpecialistReport> specialistReports = new ArrayList<>();


        for (Specialist spec : timeService.getAviationData().getSpecialists()) {
            SpecialistReport specialistReport = new SpecialistReport();
            specialistReport.setId(spec.getId());
            specialistReport.setName(spec.getName());


            List<MonthlyReport> monthlyReports = new ArrayList<>();

            for (Map.Entry<Month, Double> entry : spec.getMonthlyHours().entrySet()) {
                MonthlyReport monthlyReport = new MonthlyReport();
                monthlyReport.setPeriod(String.valueOf(YearMonth.of(
                        timeService.getAviationData().getFlights().get(0).getLandingTimeUtc().getYear(),
                        entry.getKey().getValue())));
                monthlyReport.setTotalFlightTimeHours(entry.getValue());


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

                monthlyReport.setViolationFlags(violations);
                monthlyReports.add(monthlyReport);

            }

            specialistReport.setMonthlyReports(monthlyReports);
            specialistReports.add(specialistReport);

        }

        aviationReport.setSpecialistReports(specialistReports);
        return aviationReport;

    }
}
