package com.keyin.Passengers;

import com.keyin.Aircraft.Aircraft;
import com.keyin.Airport.Airport;
import com.keyin.Cities.Cities;
import jakarta.persistence.*;
import java.util.List;


// Represents a Passenger entity for the database
@Entity
public class Passengers {

    @Id
    @SequenceGenerator(name = "passengers_sequence", sequenceName = "passengers_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "passengers_sequence")
    private long id;

    private String firstName; // Passengers First Name
    private String lastName; // Passengers Last Name
    private String phoneNumber; // Passengers Phone Number


    @ManyToOne
    public Cities city;


    @ManyToMany
    @JoinTable(
            name = "passenger_aircraft",
            joinColumns = @JoinColumn(name = "passenger_id"),
            inverseJoinColumns = @JoinColumn(name = "aircraft_id")
    )
    private List<Aircraft> aircraft;



    @ManyToMany
    @JoinTable(
            name = "passenger_airport",
            joinColumns = @JoinColumn(name = "passenger_id"),
            inverseJoinColumns = @JoinColumn(name = "airport_id")
    )
    private List<Airport> airports;



    // Getters and setters for each field

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public Cities getCity() { return city; }
    public void setCity(Cities city) { this.city = city; }

    public List<Aircraft> getAircraft() { return aircraft; }
    public void setAircraft(List<Aircraft> aircraft) { this.aircraft = aircraft; }


    public List<Airport> getAirports() { return airports; }
    public void setAirports(List<Airport> airports) { this.airports = airports; }
}
