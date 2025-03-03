package com.keyin.Airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {
    @Autowired
    private AirportRepository airportRepository;

    // Get list of airports by city ID
    public List<Airport> getAirportsByCityId(Long cityId) {
        return airportRepository.findByCityId(cityId);
    }

    // Create a new airport
    public Airport createAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    // Get all airports
    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }
}
