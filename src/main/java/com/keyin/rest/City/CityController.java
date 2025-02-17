package com.keyin.rest.City;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping("/cities")
    public List<City> getAllCities() {
        return cityService.findAllCities();
    }

    @GetMapping("/cities/{id}")
    public City getCityByID(@PathVariable long id) {
        return cityService.findCityById(id);
    }

    @PostMapping("/cities")
    public City createCity(@RequestBody City newCity) {
        return cityService.createCity(newCity);
    }

    @PutMapping("/cities/{id}")
    public City updateCity(@PathVariable long id, @RequestBody City updatedCity) {
        return cityService.updateCity(id, updatedCity);
    }
}
