package com.keyin.Airport;

import com.keyin.Cities.Cities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class AirportController {
    @Autowired
    private AirportService airportService;

    // Get airports by specific city
    @GetMapping("/{cityId}/airports")
    public ResponseEntity<List<Airport>> getAirportsByCityId(@PathVariable Long cityId) {
        List<Airport> airports = airportService.getAirportsByCityId(cityId);
        if (airports.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(airports);
    }

    // Create a new airport for a specific city
    @PostMapping("/{cityId}/airports")
    public Airport createAirport(@PathVariable Long cityId, @RequestBody Airport airport) {
        // Set the city for the airport
        Cities city = new Cities();
        city.setId(cityId);
        airport.setCity(city);
        return airportService.createAirport(airport);
    }

    // Get all airports for aircraft operations
    @GetMapping("/airports-for-operations")
    public ResponseEntity<List<Airport>> getAirportsForAircraftOperations() {
        List<Airport> airports = airportService.getAllAirports();
        if (airports.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(airports);
    }
}