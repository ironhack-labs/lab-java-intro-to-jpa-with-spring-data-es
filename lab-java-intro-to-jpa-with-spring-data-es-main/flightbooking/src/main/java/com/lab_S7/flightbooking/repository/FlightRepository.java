package com.lab_S7.flightbooking.repository;

import com.lab_S7.flightbooking.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
