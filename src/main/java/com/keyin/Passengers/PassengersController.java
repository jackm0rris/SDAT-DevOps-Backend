package com.keyin.Passengers;

import com.keyin.Aircraft.Aircraft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/passengers")
public class PassengersController {

    @Autowired
    private PassengersService passengersService;

    // Get all passengers
    @GetMapping
    public List<Passengers> getAllPassengers() {
        return passengersService.findAllPassengers();
    }

    // Get one passenger by ID
    @GetMapping("/{id}")
    public Passengers getPassengerById(@PathVariable long id) {
        return passengersService.findPassengerById(id);
    }

    // Create a new passenger
    @PostMapping
    public Passengers createPassenger(@RequestBody Passengers newPassenger) {
        return passengersService.createPassenger(newPassenger);
    }

    // Update existing passenger by ID
    @PutMapping("/{id}")
    public Passengers updatePassenger(@PathVariable long id, @RequestBody Passengers updatedPassenger) {
        return passengersService.updatePassenger(id, updatedPassenger);
    }

    // Get all aircraft linked to a passenger
    @GetMapping("/{id}/aircraft")
    public List<Aircraft> getAircraftForPassenger(@PathVariable long id) {
        return passengersService.findAircraftForPassenger(id);
    }

    // Link an aircraft to a passenger
    @PostMapping("/{passengerId}/aircraft/{aircraftId}")
    public ResponseEntity<String> addAircraftToPassenger(@PathVariable long passengerId, @PathVariable long aircraftId) {
        return passengersService.addAircraftToPassenger(passengerId, aircraftId);
    }

    // Remove an aircraft from a passenger
    @DeleteMapping("/{passengerId}/aircraft/{aircraftId}")
    public ResponseEntity<String> removeAircraftFromPassenger(@PathVariable long passengerId, @PathVariable long aircraftId) {
        return passengersService.removeAircraftFromPassenger(passengerId, aircraftId);
    }
}
