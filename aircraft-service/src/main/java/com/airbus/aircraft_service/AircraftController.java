package com.airbus.aircraft_service;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/aircraft")
public class AircraftController {

    private final AircraftRepository repository;

    public AircraftController(AircraftRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String getAircraft() {
        return "Airbus A320";
    }

    @PostMapping
    public Aircraft saveAircraft(@RequestBody Aircraft aircraft) {
        return repository.save(aircraft);
    }

    @GetMapping("/all")
    public List<Aircraft> getAllAircraft() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Aircraft getAircraftById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Aircraft updateAircraft(@PathVariable Long id,
            @RequestBody Aircraft aircraft) {

        Aircraft existing = repository.findById(id).orElse(null);

        if (existing != null) {
            existing.setName(aircraft.getName());
            return repository.save(existing);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteAircraft(@PathVariable Long id) {

        repository.deleteById(id);

        return "Aircraft Deleted";
    }
}