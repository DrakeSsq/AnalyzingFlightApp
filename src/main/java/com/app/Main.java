package com.app;

import com.app.exceptions.CustomJsonException;
import com.app.models.AviationData;
import com.app.models.reports.AviationReport;
import com.app.services.ReportService;
import com.app.services.TimeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {

        File file = new File(args[0]);

        if (!file.exists()) {
            throw new FileNotFoundException("file not found");
        } else {

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

            try {
                AviationData data = objectMapper.readValue(file, AviationData.class);

                TimeService timeService = new TimeService(data);
                timeService.calculateTime();

                ReportService reportService = new ReportService(timeService);
                AviationReport aviationReport = reportService.generateReport();

                objectMapper.writeValue(new File("output.json"), aviationReport);

            } catch (JsonProcessingException e) {
                throw new CustomJsonException("The incoming file contains an unsupported data format");
            }

        }
    }
}
