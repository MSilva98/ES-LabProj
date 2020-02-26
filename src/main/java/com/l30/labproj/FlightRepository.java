package com.l30.labproj;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface FlightRepository extends CrudRepository<Flight, Long> {

  List<Flight> findByEstDepartureAirport(String estDepartureAirport);

  Flight findById(long id);
}