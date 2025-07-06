package com.app.models;

import lombok.Data;

import java.util.List;

@Data
public class AviationData {

    private List<Specialist> specialists;
    private List<Flight> flights;
}
