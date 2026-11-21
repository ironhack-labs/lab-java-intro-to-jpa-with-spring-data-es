package com.ironhack.airlinebooking.repository;

import com.ironhack.airlinebooking.model.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightBookingRepository extends JpaRepository<FlightBooking, Integer> {

    List<FlightBooking> findByCustomerId(Integer customerId);

    /** Extra practice: every booking on one flight. */
    List<FlightBooking> findByFlightId(Integer flightId);
}
