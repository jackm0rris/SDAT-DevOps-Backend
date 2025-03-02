package com.keyin.Airport;

import com.keyin.Cities.Cities;
import jakarta.persistence.*;

@Entity
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String code;

    @ManyToOne
    @JoinColumn(name = "cities_id", nullable = false) // cities_id column
    private Cities city;

    // Default constructor
    public Airport() {
    }

    // constructor
    public Airport(String name, String code, Cities city) {
        this.name = name;
        this.code = code;
        this.city = city;
    }

    // Getters and Setters
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Cities getCity() {
        return city;
    }

    public void setCity(Cities city) {
        this.city = city;
    }
}