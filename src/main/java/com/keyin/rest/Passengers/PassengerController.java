package com.keyin.rest.Passengers;

import com.keyin.rest.Passengers.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class PassengerController {
    @Autowired
    private PassengerService passengerService;

    @GetMapping("/passengers")
    public List<Passenger> getAllPassengers() {
        return passengerService.findAllPassengers();
    }

    @GetMapping("/passengers/{id}")
    public Passenger getPassengerByID(@PathVariable long id) {
        return passengerService.findPassengerById(id);
    }

    @PostMapping("/passengers")
    public Passenger createPassenger(@RequestBody Passenger newPassenger) {
        return passengerService.createPassenger(newPassenger);
    }

    @PutMapping("/passengers/{id}")
    public Passenger updatePassenger(@PathVariable long id, @RequestBody Passenger updatedPassenger) {
        return passengerService.updatePassenger(id, updatedPassenger);
    }
}
