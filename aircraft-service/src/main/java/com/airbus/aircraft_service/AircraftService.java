package com.airbus.aircraft_service;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AircraftService {

    private final AircraftRepository repository;

    public AircraftService(AircraftRepository repository) {
        this.repository = repository;
    }

    public Aircraft saveAircraft(Aircraft aircraft) {
        return repository.save(aircraft);
    }

    public List<Aircraft> getAllAircraft() {
        return repository.findAll();
    }

    public Aircraft getAircraftById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Aircraft updateAircraft(Long id, Aircraft aircraft) {

        Aircraft existing = repository.findById(id).orElse(null);

        if (existing != null) {
            existing.setName(aircraft.getName());
            return repository.save(existing);
        }

        return null;
    }

    public void deleteAircraft(Long id) {
        repository.deleteById(id);
    }
    public Aircraft saveAircraft(AircraftRequestDTO dto) {

        Aircraft aircraft = new Aircraft();

        aircraft.setName(dto.getName());

        return repository.save(aircraft);
    }
}