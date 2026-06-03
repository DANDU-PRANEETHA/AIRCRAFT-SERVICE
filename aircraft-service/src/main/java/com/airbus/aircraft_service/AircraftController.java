package com.airbus.aircraft_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AircraftController {

    @GetMapping("/aircraft")
    public String getAircraft() {
        return "Airbus A320";
    }
}