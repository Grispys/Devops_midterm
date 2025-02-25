package com.keyin.rest.Airport;

import com.keyin.rest.City.City;
import jakarta.persistence.*;

import java.util.ArrayList;


//this is just the airport class we went over in many examples. it along with its controller, service, and repository stay mostly unchanged.
@Entity
public class Airport {
    @Id
    @SequenceGenerator(name = "airport_sequence", sequenceName = "airport_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "airport_sequence")
    private long id;

    private String code;
    private String name;

    public Airport(){

    }


    public Airport(String name, String code) {
        this.name = name;
        this.code = code;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
//
//    public City getCity() {
//        return city;
//    }
//
//    public void setCity(City city) {
//        this.city = city;
//    }
}
