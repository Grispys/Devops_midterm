package com.keyin.rest.Aircraft;

import com.keyin.rest.Airport.Airport;
import com.keyin.rest.Airport.AirportRepository;
import com.keyin.rest.Passengers.Passenger;
import com.keyin.rest.Passengers.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AircraftService {
    @Autowired
    private AircraftRepository aircraftRepository;
    @Autowired
    private PassengerRepository passengerRepository;
    @Autowired
    private AirportRepository airportRepository;

    public List<Aircraft> findAllAircrafts() {
        return (List<Aircraft>) aircraftRepository.findAll();
    }

    public Aircraft findAircraftById(long id) {
        Optional<Aircraft> optionalAircraft = aircraftRepository.findById(id);

        return optionalAircraft.orElse(null);
    }


//    create aircraft method now, like createCity, makes a new list of passengers based on the
//    passengers available and iterates through each one until the given id from the postman api
//    is found, and then added

//    also added airports to this as well, just took the loop from cities airport connections and plopped it here

    public Aircraft createAircraft(Aircraft newAircraft) {
        List<Passenger> updatedPassengers = new ArrayList<>();
        List<Airport> updatedAirports = new ArrayList<>();

        for(Passenger passenger : newAircraft.getPassengers()){
            long passengerID = passenger.getId();
            Passenger passenger1 = getPassengerById(passengerID);

            if (passenger1 !=null){
                updatedPassengers.add(passenger1);
            } else{
                passengerRepository.save(passenger);
                updatedPassengers.add(passenger);
            }
        }

        for (Airport airport : newAircraft.getAirports()) {
            long airportId = airport.getId();
            Airport airport1 = getAirportById(airportId);

            if (airport1 != null) {
                updatedAirports.add(airport1);
            } else {
                airportRepository.save(airport);
                updatedAirports.add(airport);
            }
        }

        newAircraft.setAirports(updatedAirports);
        newAircraft.setPassengers(updatedPassengers);

        return aircraftRepository.save(newAircraft);
    }

    public Aircraft updateAircraft(long id, Aircraft updatedAircraft) {
        Aircraft AircraftToUpdate = findAircraftById(id);

        if (AircraftToUpdate != null) {
            AircraftToUpdate.setNumOfPassengers(updatedAircraft.getNumOfPassengers());
            AircraftToUpdate.setType(updatedAircraft.getType());
            AircraftToUpdate.setAirlineName(updatedAircraft.getAirlineName());

            return aircraftRepository.save(AircraftToUpdate);
        }

        return null;
    }


    public Passenger getPassengerById(Long id){
        return passengerRepository.findById(id).orElse(null);
    }

    public Airport getAirportById(Long id) {    return airportRepository.findById(id).orElse(null);}


}
