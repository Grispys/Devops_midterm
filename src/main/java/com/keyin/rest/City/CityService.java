package com.keyin.rest.City;

import com.keyin.rest.Airport.Airport;
import com.keyin.rest.Airport.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private AirportRepository airportRepository;

    public List<City> findAllCities() {
        return (List<City>) cityRepository.findAll();
    }

    public City findCityById(long id) {
        Optional<City> optionalCity = cityRepository.findById(id);

        return optionalCity.orElse(null);
    }

    public City createCity(City newCity) {
        List<Airport> updatedAirports = new ArrayList<>();

        for (Airport airport : newCity.getAirports()) {
            long airportId = airport.getId();
            Airport airport1 = getAirportById(airportId);

            if (airport1 != null) {
                updatedAirports.add(airport1);
            } else {
                airportRepository.save(airport);
                updatedAirports.add(airport);
            }
        }

        newCity.setAirports(updatedAirports); // Safely update the list

        return cityRepository.save(newCity);
    }


    public City updateCity(long id, City updatedCity) {
        City CityToUpdate = findCityById(id);

        if (CityToUpdate != null) {
            CityToUpdate.setPopulation(updatedCity.getPopulation());
            CityToUpdate.setName(updatedCity.getName());

            return cityRepository.save(CityToUpdate);
        }

        return null;
    }

    public Airport getAirportById(Long id) {    return airportRepository.findById(id).orElse(null);}
}
