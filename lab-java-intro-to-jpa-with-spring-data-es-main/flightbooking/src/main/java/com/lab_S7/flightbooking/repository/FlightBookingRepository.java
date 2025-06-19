package com.lab_S7.flightbooking.repository;

import com.lab_S7.flightbooking.model.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightBookingRepository extends JpaRepository<FlightBooking, Long> {
    List<FlightBooking> findByCustomerId(Long customerId);
}
