package com.keyin.Airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {
    @Autowired
    private AirportRepository airportRepository;
    // Gets list of airports ny city id
    public List<Airport> getAirportsByCityId(Long cityId) {
        return airportRepository.findByCityId(cityId);
    }

    public Airport createAirport(Airport airport) {
        return airportRepository.save(airport);
    }


}
