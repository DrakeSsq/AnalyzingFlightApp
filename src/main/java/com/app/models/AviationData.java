package com.app.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AviationData {

    private List<Specialist> specialists;
    private List<Flight> flights;
}
