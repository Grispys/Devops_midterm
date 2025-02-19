package com.keyin.rest.City;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class CityController {

    private final CityRepository cityRepository;

    public CityController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

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


//    created deleting query for postman, will just copy and paste this into every other controller later
    @DeleteMapping("cities/{id}")
    public ResponseEntity<String> deleteCity(@PathVariable long id) {
        if (!cityRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        cityRepository.deleteById(id);
        return ResponseEntity.ok("City Deleted.");
    }
}
