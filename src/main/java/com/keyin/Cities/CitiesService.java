package com.keyin.Cities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitiesService {

    @Autowired
    private CitiesRepository citiesRepository;

    // Get all cities from the database
    public List<Cities> getAllCities() {
        return citiesRepository.findAll();
    }

    // Find a specific city by its ID
    public Optional<Cities> getCityById(Long id) {
        return citiesRepository.findById(id);
    }

    // Create a new city and save it to the database
    public Cities createCity(Cities city) {
        return citiesRepository.save(city);
    }
}
