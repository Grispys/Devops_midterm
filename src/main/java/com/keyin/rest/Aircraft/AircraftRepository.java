package com.keyin.rest.Aircraft;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AircraftRepository extends CrudRepository<Aircraft, Long> {
    Aircraft findByAirlineName(String airlineName);
}
