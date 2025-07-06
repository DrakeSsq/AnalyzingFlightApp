package com.app.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Flight {

    @JsonProperty("aircraft_type")
    private String aircraftType;

    @JsonProperty("aircraft_number")
    private String aircraftNumber;

    @JsonProperty("departure_airport")
    private String departureAirport;

    @JsonProperty("arrival_airport")
    private String arrivalAirport;

    @JsonProperty("takeoff_time_utc")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime takeoffTimeUtc;

    @JsonProperty("landing_time_utc")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime landingTimeUtc;

    @JsonProperty("crew")
    private List<Integer> crew;
}
