package com.app.services;

import com.app.models.AviationData;
import com.app.models.Specialist;
import com.app.util.TestInfoFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

public class TimeServiceTest {

    private TimeService timeService;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        timeService = new TimeService();
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }


    @Test
    void simpleFlightTime() throws JsonProcessingException {

        String input = TestInfoFactory.getDataForSimpleFlightTime();

        AviationData aviationData = objectMapper.readValue(input, AviationData.class);
        timeService.calculateTime(aviationData);

        Month month = aviationData.getFlights().get(0).getLandingTimeUtc().getMonth();

        assertEquals(28.50, aviationData.getSpecialists().get(0).getMonthlyHours().get(month));
    }

    @Test
    void severalDaysFlightTime() throws JsonProcessingException{

        String input = TestInfoFactory.getDataForSeveralDaysFlightTime();

        AviationData aviationData = objectMapper.readValue(input, AviationData.class);
        timeService.calculateTime(aviationData);

        Month month = aviationData.getFlights().get(0).getLandingTimeUtc().getMonth();

        assertEquals(10.0, aviationData.getSpecialists().get(0).getMonthlyHours().get(month));

    }

    @Test
    void flightInDifferentMonths() throws JsonProcessingException{

        String input = TestInfoFactory.getDataForFlightInDifferentMonths();

        AviationData aviationData = objectMapper.readValue(input, AviationData.class);
        timeService.calculateTime(aviationData);

        Specialist specialist = aviationData.getSpecialists().get(0);


        assertEquals(4.5, specialist.getMonthlyHours().get(Month.JANUARY));
        assertEquals(2.0, specialist.getMonthlyHours().get(Month.FEBRUARY));
        assertEquals(4.0, specialist.getMonthlyHours().get(Month.MARCH));
    }

    @Test
    void definitionOfDayViolations() throws JsonProcessingException {
        String input = TestInfoFactory.getDataForDefinitionOfDayViolations();

        AviationData aviationData = objectMapper.readValue(input, AviationData.class);
        timeService.calculateTime(aviationData);

        Specialist spec = aviationData.getSpecialists().get(0);
        Month month = aviationData.getFlights().get(0).getLandingTimeUtc().getMonth();

        assertTrue(spec.getDailyHoursViolation().get(month));
    }

    @Test
    void definitionOfWeekViolations() throws JsonProcessingException {
        String input = TestInfoFactory.getDataForDefinitionOfWeekViolations();

        AviationData aviationData = objectMapper.readValue(input, AviationData.class);
        timeService.calculateTime(aviationData);

        Specialist spec = aviationData.getSpecialists().get(0);
        Month month = aviationData.getFlights().get(0).getLandingTimeUtc().getMonth();

        assertTrue(spec.getWeeklyHoursViolations().get(month));
        assertNull(spec.getDailyHoursViolation().get(month));

    }

    @Test
    void definitionOfMonthViolations() throws JsonProcessingException {
        String input = TestInfoFactory.getDataForDefinitionOfMonthViolations();

        AviationData aviationData = objectMapper.readValue(input, AviationData.class);
        timeService.calculateTime(aviationData);

        Specialist spec = aviationData.getSpecialists().get(0);
        Month month = aviationData.getFlights().get(0).getLandingTimeUtc().getMonth();

        assertTrue(spec.getMonthlyHoursViolation().get(month));
        assertNull(spec.getDailyHoursViolation().get(month));
        assertTrue(spec.getWeeklyHoursViolations().get(month));
    }

    @Test
    void intersectionOfDay() throws JsonProcessingException {
        String input = TestInfoFactory.getDataForIntersectionOfDay();

        AviationData aviationData = objectMapper.readValue(input, AviationData.class);
        timeService.calculateTime(aviationData);

        Specialist spec = aviationData.getSpecialists().get(0);
        Month month = aviationData.getFlights().get(0).getLandingTimeUtc().getMonth();

        assertEquals(2.5, spec.getMonthlyHours().get(month));
    }

    @Test
    void intersectionOfWeek() throws JsonProcessingException {
        String input = TestInfoFactory.getDataForIntersectionOfWeek();

        AviationData aviationData = objectMapper.readValue(input, AviationData.class);
        timeService.calculateTime(aviationData);

        Specialist spec = aviationData.getSpecialists().get(0);

        assertNull(spec.getWeeklyHoursViolations().get(Month.JULY));
    }

    @Test
    void intersectionOfMonth() throws JsonProcessingException {
        String input = TestInfoFactory.getDataForIntersectionOfMonth();

        AviationData aviationData = objectMapper.readValue(input, AviationData.class);
        timeService.calculateTime(aviationData);

        Specialist spec = aviationData.getSpecialists().get(0);

        assertEquals(8.0, spec.getMonthlyHours().get(Month.JULY));
        assertEquals(10.5, spec.getMonthlyHours().get(Month.AUGUST));
    }
}
