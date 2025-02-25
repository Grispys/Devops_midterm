package com.keyin.rest.Passengers;

import com.keyin.rest.Airport.Airport;
import com.keyin.rest.City.City;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Passenger {
    @Id
    @SequenceGenerator(name = "passenger_sequence", sequenceName = "passenger_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "passenger_sequence")
    private long id;

//    ATTENTION
//    i could not get the program to even run if i had a manytoone connection from passenger to city. it didnt recognize "list" as an entity? according to the stack
//    trace. sorry



    @ManyToOne
    public City city;

    private String firstName;
    private String lastName;
    private Integer phoneNumber;

    public Passenger(){

    }

    public Passenger(String firstName, String lastName, Integer phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.city = new City();
    }






    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
