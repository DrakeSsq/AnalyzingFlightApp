package com.app.util;

public class TestInfoFactory {

    public static String getDataForSimpleFlightTime() {
        return """
            {
                "specialists": [{"id": 1, "name": "Test Specialist"}],
                "flights": [
                    {
                        "aircraft_type": "Airbus A320",
                        "aircraft_number": "VP-BOC",
                        "departure_airport": "Екатеринбург (SVX)",
                        "arrival_airport": "Москва (DME)",
                        "takeoff_time_utc": "2021-01-10T08:00:00Z",
                        "landing_time_utc": "2021-01-11T12:30:00Z",
                        "crew": [1]
                    }
                ]
            }
            """;
    }

    public static String getDataForSeveralDaysFlightTime() {
        return """
            {
                "specialists": [{"id": 1, "name": "Test Specialist"}],
                "flights": [
                    {
                        "aircraft_type": "Airbus A320",
                        "aircraft_number": "VP-BOC",
                        "departure_airport": "Екатеринбург (SVX)",
                        "arrival_airport": "Москва (DME)",
                        "takeoff_time_utc": "2021-01-10T08:00:00Z",
                        "landing_time_utc": "2021-01-10T12:00:00Z",
                        "crew": [1]
                    },
                    {
                        "aircraft_type": "Airbus A320",
                        "aircraft_number": "VP-BOC",
                        "departure_airport": "Екатеринбург (SVX)",
                        "arrival_airport": "Москва (DME)",
                        "takeoff_time_utc": "2021-01-11T23:00:00Z",
                        "landing_time_utc": "2021-01-12T01:00:00Z",
                        "crew": [1]
                    },
                    {
                        "aircraft_type": "Airbus A320",
                        "aircraft_number": "VP-BOC",
                        "departure_airport": "Екатеринбург (SVX)",
                        "arrival_airport": "Москва (DME)",
                        "takeoff_time_utc": "2021-01-12T11:00:00Z",
                        "landing_time_utc": "2021-01-12T15:00:00Z",
                        "crew": [1]
                    }
                ]
            }
            """;
    }

    public static String getDataForFlightInDifferentMonths() {
        return """
            {
                "specialists": [{"id": 1, "name": "Test Specialist"}],
                "flights": [
                    {
                        "aircraft_type": "Airbus A320",
                        "aircraft_number": "VP-BOC",
                        "departure_airport": "Екатеринбург (SVX)",
                        "arrival_airport": "Москва (DME)",
                        "takeoff_time_utc": "2021-01-10T08:00:00Z",
                        "landing_time_utc": "2021-01-10T12:30:00Z",
                        "crew": [1]
                    },
                    {
                        "aircraft_type": "Airbus A320",
                        "aircraft_number": "VP-BOC",
                        "departure_airport": "Екатеринбург (SVX)",
                        "arrival_airport": "Москва (DME)",
                        "takeoff_time_utc": "2021-02-11T23:00:00Z",
                        "landing_time_utc": "2021-02-12T01:00:00Z",
                        "crew": [1]
                    },
                    {
                        "aircraft_type": "Airbus A320",
                        "aircraft_number": "VP-BOC",
                        "departure_airport": "Екатеринбург (SVX)",
                        "arrival_airport": "Москва (DME)",
                        "takeoff_time_utc": "2021-03-12T11:00:00Z",
                        "landing_time_utc": "2021-03-12T15:00:00Z",
                        "crew": [1]
                    }
                ]
            }
            """;
    }

    public static String getDataForDefinitionOfDayViolations() {
        return """
            {
                "specialists": [{"id": 1, "name": "Test Specialist"}],
                "flights": [
                    {
                        "aircraft_type": "Airbus A320",
                        "aircraft_number": "VP-BOC",
                        "departure_airport": "Екатеринбург (SVX)",
                        "arrival_airport": "Москва (DME)",
                        "takeoff_time_utc": "2021-01-10T08:00:00Z",
                        "landing_time_utc": "2021-01-11T20:30:00Z",
                        "crew": [1]
                    }
                ]
            }
            """;
    }

    public static String getDataForDefinitionOfWeekViolations() {
        return """
            {
                "specialists": [{"id": 1, "name": "Test Specialist"}],
                "flights": [
                    {
                        "aircraft_type": "Airbus A320",
                        "aircraft_number": "VP-BOC",
                        "departure_airport": "Екатеринбург (SVX)",
                        "arrival_airport": "Москва (DME)",
                        "takeoff_time_utc": "2025-07-07T10:00:00Z",
                        "landing_time_utc": "2025-07-07T18:00:00Z",
                        "crew": [1]
                    },
                    {
                        "aircraft_type": "Airbus A320",
                        "aircraft_number": "VP-BOC",
                        "departure_airport": "Екатеринбург (SVX)",
                        "arrival_airport": "Москва (DME)",
                        "takeoff_time_utc": "2025-07-08T10:00:00Z",
                        "landing_time_utc": "2025-07-08T18:00:00Z",
                        "crew": [1]
                    },
                    {
                        "aircraft_type": "Airbus A320",
                        "aircraft_number": "VP-BOC",
                        "departure_airport": "Екатеринбург (SVX)",
                        "arrival_airport": "Москва (DME)",
                        "takeoff_time_utc": "2025-07-09T10:00:00Z",
                        "landing_time_utc": "2025-07-09T18:00:00Z",
                        "crew": [1]
                    },
                    {
                        "aircraft_type": "Airbus A320",
                        "aircraft_number": "VP-BOC",
                        "departure_airport": "Екатеринбург (SVX)",
                        "arrival_airport": "Москва (DME)",
                        "takeoff_time_utc": "2025-07-10T10:00:00Z",
                        "landing_time_utc": "2025-07-10T18:00:00Z",
                        "crew": [1]
                    },
                    {
                        "aircraft_type": "Airbus A320",
                        "aircraft_number": "VP-BOC",
                        "departure_airport": "Екатеринбург (SVX)",
                        "arrival_airport": "Москва (DME)",
                        "takeoff_time_utc": "2025-07-11T10:00:00Z",
                        "landing_time_utc": "2025-07-11T18:00:00Z",
                        "crew": [1]
                    }
                ]
            }
            """;
    }

    public static String getDataForDefinitionOfMonthViolations() {
        return """
            {
                "specialists": [{"id": 1, "name": "Test Specialist"}],
                "flights": [
                    {
                        "aircraft_type": "Airbus A320",
                        "aircraft_number": "VP-BOC",
                        "departure_airport": "Екатеринбург (SVX)",
                        "arrival_airport": "Москва (DME)",
                        "takeoff_time_utc": "2025-07-07T10:00:00Z",
                        "landing_time_utc": "2025-07-07T18:00:00Z",
                        "crew": [1]
                    },
                    {
                        "aircraft_type": "Airbus A320",
                        "aircraft_number": "VP-BOC",
                        "departure_airport": "Екатеринбург (SVX)",
                        "arrival_airport": "Москва (DME)",
                        "takeoff_time_utc": "2025-07-08T10:00:00Z",
                        "landing_time_utc": "2025-07-08T18:00:00Z",
                        "crew": [1]
                    },
                    {
                        "aircraft_type": "Airbus A320",
                        "aircraft_number": "VP-BOC",
                        "departure_airport": "Екатеринбург (SVX)",
                        "arrival_airport": "Москва (DME)",
                        "takeoff_time_utc": "2025-07-09T10:00:00Z",
                        "landing_time_utc": "2025-07-09T18:00:00Z",
                        "crew": [1]
                    },
                    {
                        "aircraft_type": "Airbus A320",
                        "aircraft_number": "VP-BOC",
                        "departure_airport": "Екатеринбург (SVX)",
                        "arrival_airport": "Москва (DME)",
                        "takeoff_time_utc": "2025-07-10T10:00:00Z",
                        "landing_time_utc": "2025-07-10T18:00:00Z",
                        "crew": [1]
                    },
                    {
                        "aircraft_type": "Airbus A320",
                        "aircraft_number": "VP-BOC",
                        "departure_airport": "Екатеринбург (SVX)",
                        "arrival_airport": "Москва (DME)",
                        "takeoff_time_utc": "2025-07-11T10:00:00Z",
                        "landing_time_utc": "2025-07-11T18:00:00Z",
                        "crew": [1]
                    },
                    {
                        "aircraft_type": "Airbus A320",
                        "aircraft_number": "VP-BOC",
                        "departure_airport": "Екатеринбург (SVX)",
                        "arrival_airport": "Москва (DME)",
                        "takeoff_time_utc": "2025-07-12T10:00:00Z",
                        "landing_time_utc": "2025-07-12T18:00:00Z",
                        "crew": [1]
                    },
                    {
                        "aircraft_type": "Airbus A320",
                        "aircraft_number": "VP-BOC",
                        "departure_airport": "Екатеринбург (SVX)",
                        "arrival_airport": "Москва (DME)",
                        "takeoff_time_utc": "2025-07-13T10:00:00Z",
                        "landing_time_utc": "2025-07-13T18:00:00Z",
                        "crew": [1]
                    },
                    {
                        "aircraft_type": "Airbus A320",
                        "aircraft_number": "VP-BOC",
                        "departure_airport": "Екатеринбург (SVX)",
                        "arrival_airport": "Москва (DME)",
                        "takeoff_time_utc": "2025-07-14T10:00:00Z",
                        "landing_time_utc": "2025-07-14T18:00:00Z",
                        "crew": [1]
                    },
                    {
                        "aircraft_type": "Airbus A320",
                        "aircraft_number": "VP-BOC",
                        "departure_airport": "Екатеринбург (SVX)",
                        "arrival_airport": "Москва (DME)",
                        "takeoff_time_utc": "2025-07-15T10:00:00Z",
                        "landing_time_utc": "2025-07-15T18:00:00Z",
                        "crew": [1]
                    },
                    {
                        "aircraft_type": "Airbus A320",
                        "aircraft_number": "VP-BOC",
                        "departure_airport": "Екатеринбург (SVX)",
                        "arrival_airport": "Москва (DME)",
                        "takeoff_time_utc": "2025-07-16T10:00:00Z",
                        "landing_time_utc": "2025-07-16T18:00:00Z",
                        "crew": [1]
                    },
                    {
                        "aircraft_type": "Airbus A320",
                        "aircraft_number": "VP-BOC",
                        "departure_airport": "Екатеринбург (SVX)",
                        "arrival_airport": "Москва (DME)",
                        "takeoff_time_utc": "2025-07-17T10:00:00Z",
                        "landing_time_utc": "2025-07-17T18:00:00Z",
                        "crew": [1]
                    }
                ]
            }
            """;
    }

    public static String getDataForIntersectionOfDay() {
        return """
                {
                    "specialists": [{"id": 1, "name": "Test Specialist"}],
                    "flights": [
                        {
                            "aircraft_type": "Airbus A320",
                            "aircraft_number": "VP-BOC",
                            "departure_airport": "Екатеринбург (SVX)",
                            "arrival_airport": "Москва (DME)",
                            "takeoff_time_utc": "2021-01-10T23:00:00Z",
                            "landing_time_utc": "2021-01-11T01:30:00Z",
                            "crew": [1]
                        }
                    ]
                }
                """;
    }

    public static String getDataForIntersectionOfWeek() {
        return """
                {
                    "specialists": [{"id": 1, "name": "Test Specialist"}],
                    "flights": [
                    {
                        "aircraft_type": "Airbus A320",
                        "aircraft_number": "VP-BOC",
                        "departure_airport": "Екатеринбург (SVX)",
                        "arrival_airport": "Москва (DME)",
                        "takeoff_time_utc": "2025-07-10T10:00:00Z",
                        "landing_time_utc": "2025-07-10T18:00:00Z",
                        "crew": [1]
                    },
                    {
                        "aircraft_type": "Airbus A320",
                        "aircraft_number": "VP-BOC",
                        "departure_airport": "Екатеринбург (SVX)",
                        "arrival_airport": "Москва (DME)",
                        "takeoff_time_utc": "2025-07-11T10:00:00Z",
                        "landing_time_utc": "2025-07-11T18:00:00Z",
                        "crew": [1]
                    },
                    {
                        "aircraft_type": "Airbus A320",
                        "aircraft_number": "VP-BOC",
                        "departure_airport": "Екатеринбург (SVX)",
                        "arrival_airport": "Москва (DME)",
                        "takeoff_time_utc": "2025-07-12T10:00:00Z",
                        "landing_time_utc": "2025-07-12T18:00:00Z",
                        "crew": [1]
                    },
                    {
                        "aircraft_type": "Airbus A320",
                        "aircraft_number": "VP-BOC",
                        "departure_airport": "Екатеринбург (SVX)",
                        "arrival_airport": "Москва (DME)",
                        "takeoff_time_utc": "2025-07-13T10:00:00Z",
                        "landing_time_utc": "2025-07-13T18:00:00Z",
                        "crew": [1]
                    },
                    {
                        "aircraft_type": "Airbus A320",
                        "aircraft_number": "VP-BOC",
                        "departure_airport": "Екатеринбург (SVX)",
                        "arrival_airport": "Москва (DME)",
                        "takeoff_time_utc": "2025-07-14T10:00:00Z",
                        "landing_time_utc": "2025-07-14T18:00:00Z",
                        "crew": [1]
                    }
                    ]
                }
                """;
    }

    public static String getDataForIntersectionOfMonth() {
        return """
                {
                    "specialists": [{"id": 1, "name": "Test Specialist"}],
                    "flights": [
                    {
                        "aircraft_type": "Airbus A320",
                        "aircraft_number": "VP-BOC",
                        "departure_airport": "Екатеринбург (SVX)",
                        "arrival_airport": "Москва (DME)",
                        "takeoff_time_utc": "2025-07-10T10:00:00Z",
                        "landing_time_utc": "2025-07-10T18:00:00Z",
                        "crew": [1]
                    },
                    {
                        "aircraft_type": "Airbus A320",
                        "aircraft_number": "VP-BOC",
                        "departure_airport": "Екатеринбург (SVX)",
                        "arrival_airport": "Москва (DME)",
                        "takeoff_time_utc": "2025-08-11T10:00:00Z",
                        "landing_time_utc": "2025-08-11T20:30:00Z",
                        "crew": [1]
                    }
                   ]
                }
                """;
    }
}
