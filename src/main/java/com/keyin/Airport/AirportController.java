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
    // get airports by specific city
    @GetMapping("/{cityId}/airports")
    public ResponseEntity<List<Airport>> getAirportsByCityId(@PathVariable Long cityId) {
        List<Airport> airports = airportService.getAirportsByCityId(cityId);
        if (airports.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(airports);
    }

    @PostMapping("/{cityId}/airports")
    public Airport createAirport(@PathVariable Long cityId, @RequestBody Airport airport) {
        // Set the city for the airport
        Cities city = new Cities();
        city.setId(cityId);
        airport.setCity(city);
        return airportService.createAirport(airport);
    }
}