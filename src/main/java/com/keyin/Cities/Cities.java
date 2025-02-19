package com.keyin.Cities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Cities {
    @Id
    @SequenceGenerator(name = "cities_sequence", sequenceName = "cities_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "cities_sequence")
    private long id;

    private String name;
    private String state;
    private int population;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
}