package com.keyin.Passengers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PassengersController {
    @Autowired
    private PassengersService passengersService;

    @GetMapping("/passengers")
    public List<Passengers> getAllPassengers() {
        return passengersService.findAllPassengers();
    }

    @GetMapping("/passengers/{id}")
    public Passengers getPassengerById(@PathVariable long id) {
        return passengersService.findPassengerById(id);
    }

    @PostMapping("/passengers")
    public Passengers createPassenger(@RequestBody Passengers newPassenger) {
        return passengersService.createPassenger(newPassenger);
    }

    @PutMapping("/passengers/{id}")
    public Passengers updatePassenger(@PathVariable long id, @RequestBody Passengers updatedPassenger) {
        return passengersService.updatePassenger(id, updatedPassenger);
    }
}
