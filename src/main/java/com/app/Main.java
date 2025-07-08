package com.app;

import com.app.models.AviationData;
import com.app.models.reports.AviationReport;
import com.app.services.ReportService;
import com.app.services.TimeService;
import com.app.util.ExceptionMessages;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    private static final String LOG_NO_ARGS = "An insufficient number of arguments has been entered. Completion of the program";
    private static final String LOG_FILE_NOT_FOUND = "The file was not found. Completion of the program";
    private static final String LOG_JSON_EXCEPTION = "Error in JSON analysis. Emergency program termination";

    private static final String OUTPUT_FILE = "output.json";

    public static void main(String[] args) throws Exception {

        if (args.length == 0) {
            logger.error(LOG_NO_ARGS);
            throw ExceptionMessages.createIllegalArgumentException();
        }

        File file = new File(args[0]);

        if (!file.exists()) {
            logger.error(LOG_FILE_NOT_FOUND);
            throw ExceptionMessages.createFileNotFoundException(args[0]);
        }

        ObjectMapper objectMapper = generateObjectMapper();

        try {
            AviationData data = objectMapper.readValue(file, AviationData.class);

            TimeService timeService = new TimeService();
            timeService.calculateTime(data);

            ReportService reportService = new ReportService();
            AviationReport aviationReport = reportService.generateReport(data);

            objectMapper.writeValue(new File(OUTPUT_FILE), aviationReport);

            } catch (JsonProcessingException e) {
                logger.error(LOG_JSON_EXCEPTION);
                throw ExceptionMessages.createJsonException(e.getMessage());
            }
    }

    private static ObjectMapper generateObjectMapper() {
        return new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .enable(SerializationFeature.INDENT_OUTPUT);
    }
}
