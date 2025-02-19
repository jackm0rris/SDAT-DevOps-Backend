package com.keyin.Passengers;

import com.keyin.Cities.Cities;
import com.keyin.Cities.CitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengersService {
    @Autowired
    private PassengersRepository passengersRepository;

    @Autowired
    private CitiesService citiesService;

    public List<Passengers> findAllPassengers() {
        return (List<Passengers>) passengersRepository.findAll();
    }

    public Passengers findPassengerById(long id) {
        Optional<Passengers> optionalPassenger = passengersRepository.findById(id);
        return optionalPassenger.orElse(null);
    }

    public Passengers createPassenger(Passengers newPassenger) {
        return passengersRepository.save(newPassenger);
    }

    public Passengers updatePassenger(long id, Passengers updatedPassenger) {
        Passengers passengerToUpdate = findPassengerById(id);

        if (passengerToUpdate != null) {
            passengerToUpdate.setFirstName(updatedPassenger.getFirstName());
            passengerToUpdate.setLastName(updatedPassenger.getLastName());
            passengerToUpdate.setPhoneNumber(updatedPassenger.getPhoneNumber());
            passengerToUpdate.setId(updatedPassenger.getId());

            return passengersRepository.save(passengerToUpdate);
        }

        return null;
    }
}
