package com.keyin.Passengers;

import com.keyin.Aircraft.Aircraft;
import com.keyin.Aircraft.AircraftService;
import com.keyin.Cities.Cities;
import com.keyin.Cities.CitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PassengersService {

    @Autowired
    private PassengersRepository passengersRepository;

    @Autowired
    private CitiesService citiesService;
    @Autowired
    private AircraftService aircraftService;

    // Get all passengers from the database
    public List<Passengers> findAllPassengers() {
        return (List<Passengers>) passengersRepository.findAll();
    }

    // Find one passenger by their ID
    public Passengers findPassengerById(long id) {
        Optional<Passengers> optionalPassenger = passengersRepository.findById(id);
        return optionalPassenger.orElse(null);
    }

    // Save a new passenger to the database
    public Passengers createPassenger(Passengers newPassenger) {
        return passengersRepository.save(newPassenger);
    }

    // Update passenger details if they exist
    public Passengers updatePassenger(long id, Passengers updatedPassenger) {
        Passengers passengerToUpdate = findPassengerById(id);

        if (passengerToUpdate != null) {
            passengerToUpdate.setFirstName(updatedPassenger.getFirstName());
            passengerToUpdate.setLastName(updatedPassenger.getLastName());
            passengerToUpdate.setPhoneNumber(updatedPassenger.getPhoneNumber());
            passengerToUpdate.setCity(updatedPassenger.getCity());
            passengerToUpdate.setAircraft(updatedPassenger.getAircraft());
            return passengersRepository.save(passengerToUpdate);
        }
        return null;
    }

    // Get all aircraft linked to a specific passenger
    public List<Aircraft> findAircraftForPassenger(long id) {
        Passengers passenger = findPassengerById(id);
        if (passenger != null) {
            return passenger.getAircraft();
        }
        return null;
    }

    // Link an aircraft to a passenger
    public ResponseEntity<String> addAircraftToPassenger(long passengerId, long aircraftId) {
        Passengers passenger = findPassengerById(passengerId);
        Aircraft aircraft = aircraftService.findAircraftById(aircraftId);

        if (passenger == null || aircraft == null) {
            return ResponseEntity.badRequest().body("Invalid passenger ID or aircraft ID");
        }

        if (passenger.getAircraft() == null) {
            passenger.setAircraft(new ArrayList<>());
        }

        passenger.getAircraft().add(aircraft);
        passengersRepository.save(passenger);

        return ResponseEntity.ok("Aircraft " + aircraftId + " added to passenger " + passengerId);
    }

    // Remove an aircraft from a passenger
    public ResponseEntity<String> removeAircraftFromPassenger(long passengerId, long aircraftId) {
        Passengers passenger = findPassengerById(passengerId);
        Aircraft aircraft = aircraftService.findAircraftById(aircraftId);

        if (passenger == null || aircraft == null) {
            return ResponseEntity.badRequest().body("Invalid passenger ID or aircraft ID");
        }

        if (passenger.getAircraft() == null) {
            passenger.setAircraft(new ArrayList<>());
        }

        passenger.getAircraft().remove(aircraft);
        passengersRepository.save(passenger);

        return ResponseEntity.ok("Aircraft " + aircraftId + " removed from passenger " + passengerId);
    }
}
