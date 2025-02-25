package com.keyin.rest.Aircraft;

import com.keyin.rest.Passengers.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AircraftService {
    @Autowired
    private AircraftRepository aircraftRepository;

    public List<Aircraft> findAllAircrafts() {
        return (List<Aircraft>) aircraftRepository.findAll();
    }

    public Aircraft findAircraftById(long id) {
        Optional<Aircraft> optionalAircraft = aircraftRepository.findById(id);

        return optionalAircraft.orElse(null);
    }

    public Aircraft createAircraft(Aircraft newAircraft) {
        List<Passenger> updatedPassengers = new ArrayList<>();

        for(Passenger passenger : newAircraft.get)

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
}
