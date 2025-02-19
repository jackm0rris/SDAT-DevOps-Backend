package com.keyin.Airport;

import com.keyin.Cities.CitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportService {
    @Autowired
    private AirportRepository airportRepository;

    public List<Airport> findAllAirports() {
        return (List<Airport>) airportRepository.findAll();
    }

    public Airport findAirportById(long id) {
        Optional<Airport> optionalAirport = airportRepository.findById(id);
        return optionalAirport.orElse(null);
    }

    public Airport createAirport(Airport newAirport) {
        return airportRepository.save(newAirport);
    }

    public Airport updateAirport(long id, Airport updatedAirport) {
        Airport airportToUpdate = findAirportById(id);

        if (airportToUpdate != null) {
            airportToUpdate.setName(updatedAirport.getName());
            airportToUpdate.setCode(updatedAirport.getCode());
            airportToUpdate.setId(updatedAirport.getId());

            return airportRepository.save(airportToUpdate);
        }

        return null;
    }
}
