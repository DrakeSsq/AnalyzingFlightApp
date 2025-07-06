package com.app;

import com.app.models.AviationData;
import com.app.models.Flight;
import com.app.services.TimeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.*;
import java.time.Duration;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        File file = new File(scan.nextLine());

        scan.close();

        if (!file.exists()) {
            throw new FileNotFoundException();
        } else {

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());

            AviationData data = objectMapper.readValue(file, AviationData.class);

            TimeService timeService = new TimeService(data);
            timeService.calculateTime();
            data.getSpecialists().forEach(specialist -> System.out.println(specialist.getId() + " " + specialist.getMonthlyHours()));


        }
    }
}
