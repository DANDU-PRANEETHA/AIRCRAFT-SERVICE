package com.airbus.aircraft_service;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/aircraft")
public class AircraftController {

    private final AircraftService service;

    public AircraftController(AircraftService service) {
        this.service = service;
    }

    @GetMapping
    public String getAircraft() {
        return "Airbus A320";
    }

    @PostMapping
    public Aircraft saveAircraft(@RequestBody AircraftRequestDTO dto) {
        return service.saveAircraft(dto);
    }

    @GetMapping("/all")
    public List<Aircraft> getAllAircraft() {
        return service.getAllAircraft();
    }

    @GetMapping("/{id}")
    public Aircraft getAircraftById(@PathVariable Long id) {
        return service.getAircraftById(id);
    }

    @PutMapping("/{id}")
    public Aircraft updateAircraft(@PathVariable Long id,
            @RequestBody Aircraft aircraft) {

        return service.updateAircraft(id, aircraft);
    }

    @DeleteMapping("/{id}")
    public String deleteAircraft(@PathVariable Long id) {

        service.deleteAircraft(id);
        return "Aircraft Deleted";
    }
}