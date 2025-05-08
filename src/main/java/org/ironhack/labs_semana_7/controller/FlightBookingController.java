package org.ironhack.labs_semana_7.controller;

import org.ironhack.labs_semana_7.model.FlightBooking;
import org.ironhack.labs_semana_7.service.FlightBookingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/flightBooking")
public class FlightBookingController {

    private final FlightBookingService flightBookingService;

    public FlightBookingController(FlightBookingService flightBookingService){
        this.flightBookingService = flightBookingService;
    }

    @GetMapping("/byCustomer/{customerId}")
    public List<FlightBooking> getFlightBooking(@PathVariable Integer customerId){
        return flightBookingService.getBookingByCustomerId(customerId);
    }

    @GetMapping("/byFlight/{flightId}")
    public List<FlightBooking> getFlightId(@PathVariable Integer flightId){
        return flightBookingService.getFlightId(flightId);
    }
}
