package com.airbus.aircraft_service;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AircraftRepository
        extends JpaRepository<Aircraft, Long> {
}