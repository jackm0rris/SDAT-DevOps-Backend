package com.keyin.Aircraft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class AircraftController {
    @Autowired
    private AircraftService aircraftService;
    // Get all aircraft's
    @GetMapping("/aircrafts")
    public List<Aircraft> getAllAircrafts() {
        return aircraftService.findAllAircrafts();
    }
    // Get aircraft by id
    @GetMapping("/aircrafts/{id}")
    public Aircraft getAircraftsByID(@PathVariable long id) {
        return aircraftService.findAircraftById(id);
    }

    @PostMapping("/aircrafts")
    public Aircraft createAircraft(@RequestBody Aircraft newAircraft) {
        return aircraftService.createAircraft(newAircraft);
    }
    // Update an aircraft
    @PutMapping("/aircrafts/{id}")
    public Aircraft updateAircraft(@PathVariable long id, @RequestBody Aircraft updatedAircraft) {
        return aircraftService.updateAircraft(id, updatedAircraft);
    }
}