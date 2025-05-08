package org.ironhack.labs_semana_7;

import org.ironhack.labs_semana_7.enums.CustomerStatus;
import org.ironhack.labs_semana_7.model.Customer;
import org.ironhack.labs_semana_7.model.Flight;
import org.ironhack.labs_semana_7.model.FlightBooking;
import org.ironhack.labs_semana_7.repository.CustomerRepository;
import org.ironhack.labs_semana_7.repository.FlightBookingRepository;
import org.ironhack.labs_semana_7.repository.FlightRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LabsSemana7Application {

    public static void main(String[] args) {
        SpringApplication.run(LabsSemana7Application.class, args);
    }

    @Bean
    CommandLineRunner run(CustomerRepository customerRepository,
                          FlightRepository flightRepository,
                          FlightBookingRepository bookingRepository){

        return args -> {
            Customer alice = customerRepository.save(new Customer("Alice", CustomerStatus.GOLD, 120000));
            Flight flight = flightRepository.save(new Flight("AB123", "Boeing 747", 300, 400));
            bookingRepository.save(new FlightBooking(alice.getId(), flight.getId()));
        };
    }

}
