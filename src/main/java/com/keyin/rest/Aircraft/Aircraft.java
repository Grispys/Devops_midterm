package com.keyin.rest.Aircraft;


import com.keyin.rest.Airport.Airport;
import com.keyin.rest.Passengers.Passenger;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Aircraft {
    @Id
    @SequenceGenerator(name = "aircraft_sequence", sequenceName = "aircraft_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "aircraft_sequence")
    private long id;

    @OneToMany
    public List<Passenger> passengers;

    @OneToMany
    public List<Airport> airports;

    public Aircraft(){

    }

    public Aircraft(String type, String airlineName, Integer numOfPassengers) {
        this.type = type;
        this.airlineName = airlineName;
        this.numOfPassengers = numOfPassengers;
        this.airports = new ArrayList<Airport>();
        this.passengers = new ArrayList<Passenger>();
    }

    private String type;
    private String airlineName;
    private Integer numOfPassengers;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public Integer getNumOfPassengers() {
        return numOfPassengers;
    }

    public void setNumOfPassengers(Integer numOfPassengers) {
        this.numOfPassengers = numOfPassengers;
    }
}
