package com.keyin.Cities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CitiesController {
    @Autowired
    private CitiesService citiesService;

    @GetMapping("/cities")
    public List<Cities> getAllCities() {
        return citiesService.findAllCities();
    }

    @GetMapping("/cities/{id}")
    public Cities getCityById(@PathVariable long id) {
        return citiesService.findCityById(id);
    }

    @PostMapping("/cities")
    public Cities createCity(@RequestBody Cities newCity) {
        return citiesService.createCity(newCity);
    }

    @PutMapping("/cities/{id}")
    public Cities updateCity(@PathVariable long id, @RequestBody Cities updatedCity) {
        return citiesService.updateCity(id, updatedCity);
    }
}