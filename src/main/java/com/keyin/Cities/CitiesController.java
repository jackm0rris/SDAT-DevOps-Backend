package com.keyin.Cities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cities")
public class CitiesController {

    @Autowired
    private CitiesService citiesService;

    // Handle GET request to fetch all cities
    @GetMapping
    public List<Cities> getAllCities() {
        return citiesService.getAllCities();
    }

    // Handle GET request to fetch city by ID
    @GetMapping("/{id}")
    public ResponseEntity<Cities> getCityById(@PathVariable Long id) {
        Optional<Cities> city = citiesService.getCityById(id);
        return city.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Handle POST request to create a new city
    @PostMapping
    public Cities createCity(@RequestBody Cities city) {
        return citiesService.createCity(city);
    }
}
