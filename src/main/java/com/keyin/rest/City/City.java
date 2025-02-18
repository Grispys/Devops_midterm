package com.keyin.rest.City;

import com.keyin.rest.Airport.Airport;
import jakarta.persistence.*;

import java.util.List;


//my city class, similar to the airport class is almost every way. it just uses city, province, and population instead. getters and setter for its variables
// and the other classes for it are tuned to work with it similarly to airport.
@Entity
public class City {
    @Id
    @SequenceGenerator(name = "city_sequence", sequenceName = "city_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "city_sequence")
    private long id;

    @OneToMany
    List<Airport> airports;

    private String name;
    private String province;
    private Integer population;


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

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
