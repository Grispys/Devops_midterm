package com.keyin.rest.Airport;

import com.keyin.rest.City.City;
import com.keyin.rest.City.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportService {
    @Autowired
    private AirportRepository airportRepository;
    @Autowired
    private CityRepository cityRepository;

    public List<Airport> findAllAirports() {
        return (List<Airport>) airportRepository.findAll();
    }

    public Airport findAirportById(long id) {
        Optional<Airport> optionalAirport = airportRepository.findById(id);

        return optionalAirport.orElse(null);
    }

    public Airport createAirport(Airport newAirport) {
        return airportRepository.save(newAirport);
    }

    public Airport updateAirport(long id, Airport updatedAirport) {
        Airport airportToUpdate = findAirportById(id);

        if (airportToUpdate != null) {
            airportToUpdate.setCode(updatedAirport.getCode());
            airportToUpdate.setName(updatedAirport.getName());

            return airportRepository.save(airportToUpdate);
        }

        return null;
    }
}
