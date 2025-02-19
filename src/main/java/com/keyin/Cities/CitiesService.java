package com.keyin.Cities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitiesService {
    @Autowired
    private CitiesRepository cityRepository;

    public List<Cities> findAllCities() {
        return (List<Cities>) cityRepository.findAll();
    }

    public Cities findCityById(long id) {
        Optional<Cities> optionalCity = cityRepository.findById(id);
        return optionalCity.orElse(null);
    }

    public Cities createCity(Cities newCity) {
        return cityRepository.save(newCity);
    }

    public Cities updateCity(long id, Cities updatedCity) {
        Cities cityToUpdate = findCityById(id);

        if (cityToUpdate != null) {
            cityToUpdate.setName(updatedCity.getName());
            cityToUpdate.setState(updatedCity.getState());
            cityToUpdate.setPopulation(updatedCity.getPopulation());

            return cityRepository.save(cityToUpdate);
        }

        return null;
    }
}

