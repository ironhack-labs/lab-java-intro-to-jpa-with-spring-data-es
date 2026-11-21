package com.ironhack.airlinebooking.repository;

import com.ironhack.airlinebooking.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
}
