package com.keyin.rest.Passengers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {
    @Autowired
    private PassengerRepository passengerRepository;

    public List<Passenger> findAllPassengers() {
        return (List<Passenger>) passengerRepository.findAll();
    }

    public Passenger findPassengerById(long id) {
        Optional<Passenger> optionalPassenger = passengerRepository.findById(id);

        return optionalPassenger.orElse(null);
    }

    public Passenger createPassenger(Passenger newPassenger) {
        return passengerRepository.save(newPassenger);
    }

    public Passenger updatePassenger(long id, Passenger updatedPassenger) {
        Passenger PassengerToUpdate = findPassengerById(id);

        if (PassengerToUpdate != null) {
            PassengerToUpdate.setPhoneNumber(updatedPassenger.getPhoneNumber());
            PassengerToUpdate.setFirstName(updatedPassenger.getFirstName());
            PassengerToUpdate.setLastName(updatedPassenger.getLastName());

            return passengerRepository.save(PassengerToUpdate);
        }

        return null;
    }
}
