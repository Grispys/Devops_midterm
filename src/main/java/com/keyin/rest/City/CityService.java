package com.keyin.rest.City;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public List<City> findAllCities() {
        return (List<City>) cityRepository.findAll();
    }

    public City findCityById(long id) {
        Optional<City> optionalCity = cityRepository.findById(id);

        return optionalCity.orElse(null);
    }

    public City createCity(City newCity) {
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
}
