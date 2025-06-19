package com.lab_S7.flightbooking.Controller;

import com.lab_S7.flightbooking.model.FlightBooking;
import com.lab_S7.flightbooking.repository.FlightBookingRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class FlightBookingController {

    private final FlightBookingRepository bookingRepo;

    public FlightBookingController(FlightBookingRepository bookingRepo) {
        this.bookingRepo = bookingRepo;
    }

    @GetMapping
    public List<FlightBooking> getAllBookings() {
        return bookingRepo.findAll();
    }

    @GetMapping("/customer/{customerId}")
    public List<FlightBooking> getBookingsByCustomerId(@PathVariable Long customerId) {
        return bookingRepo.findByCustomerId(customerId);
    }
}
