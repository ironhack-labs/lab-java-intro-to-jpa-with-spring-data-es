package org.ironhack.labs_semana_7.service;


import org.ironhack.labs_semana_7.model.FlightBooking;
import org.ironhack.labs_semana_7.repository.FlightBookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FlightBookingService {

    //Inyeccion de dependencias por constructor
    private final FlightBookingRepository flightBookingRepository;

    public FlightBookingService(FlightBookingRepository flightBookingRepository){
        this.flightBookingRepository = flightBookingRepository;
    }

    public List<FlightBooking> getBookingByCustomerId(Integer customerId){
        return  flightBookingRepository.findByCustomerId(customerId);
    }

    public List<FlightBooking> getFlightId(Integer flightId){
        return flightBookingRepository.findByFlightId(flightId);
    }


}
