package com.keyin.Cities;

import com.keyin.Airport.Airport;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Cities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String state;
    private int population;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Airport> airports;

    // Default constructor
    public Cities() {
    }

    // Constructor with parameters
    public Cities(String name, String state, int population) {
        this.name = name;
        this.state = state;
        this.population = population;
    }

    // Getter and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public List<Airport> getAirports() {
        return airports;
    }

    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }
}
