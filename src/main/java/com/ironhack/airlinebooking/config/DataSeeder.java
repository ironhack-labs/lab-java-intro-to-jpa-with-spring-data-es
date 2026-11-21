package com.ironhack.airlinebooking.config;

import com.ironhack.airlinebooking.model.Customer;
import com.ironhack.airlinebooking.model.CustomerStatus;
import com.ironhack.airlinebooking.model.Flight;
import com.ironhack.airlinebooking.model.FlightBooking;
import com.ironhack.airlinebooking.repository.CustomerRepository;
import com.ironhack.airlinebooking.repository.FlightBookingRepository;
import com.ironhack.airlinebooking.repository.FlightRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Seeds the database with the airline data from Lab 3.01 on startup, then runs
 * every derived query once and logs the results so they can be checked by eye.
 */
@Configuration
public class DataSeeder {

    private static final Logger log = LoggerFactory.getLogger(DataSeeder.class);

    @Bean
    CommandLineRunner seedAndDemo(CustomerRepository customerRepo,
                                  FlightRepository flightRepo,
                                  FlightBookingRepository bookingRepo) {
        return args -> {
            Customer agustine = customerRepo.save(new Customer("Agustine Riviera", CustomerStatus.SILVER, 115235));
            Customer alaina = customerRepo.save(new Customer("Alaina Sepulvida", CustomerStatus.NONE, 6008));
            Customer tom = customerRepo.save(new Customer("Tom Jones", CustomerStatus.GOLD, 205767));
            Customer sam = customerRepo.save(new Customer("Sam Rio", CustomerStatus.NONE, 2653));
            Customer jessica = customerRepo.save(new Customer("Jessica James", CustomerStatus.SILVER, 127656));
            Customer ana = customerRepo.save(new Customer("Ana Janco", CustomerStatus.SILVER, 136773));
            Customer jennifer = customerRepo.save(new Customer("Jennifer Cortez", CustomerStatus.GOLD, 300582));
            Customer christian = customerRepo.save(new Customer("Christian Janco", CustomerStatus.SILVER, 14642));

            Flight dl143 = flightRepo.save(new Flight("DL143", "Boeing 747", 400, 135));
            Flight dl122 = flightRepo.save(new Flight("DL122", "Airbus A330", 236, 4370));
            Flight dl53 = flightRepo.save(new Flight("DL53", "Boeing 777", 264, 2078));
            Flight dl222 = flightRepo.save(new Flight("DL222", "Boeing 777", 264, 1765));
            Flight dl37 = flightRepo.save(new Flight("DL37", "Boeing 747", 400, 531));

            bookingRepo.saveAll(List.of(
                    new FlightBooking(agustine.getId(), dl143.getId()),
                    new FlightBooking(agustine.getId(), dl122.getId()),
                    new FlightBooking(alaina.getId(), dl122.getId()),
                    new FlightBooking(tom.getId(), dl122.getId()),
                    new FlightBooking(tom.getId(), dl53.getId()),
                    new FlightBooking(tom.getId(), dl222.getId()),
                    new FlightBooking(sam.getId(), dl143.getId()),
                    new FlightBooking(jessica.getId(), dl143.getId()),
                    new FlightBooking(jessica.getId(), dl122.getId()),
                    new FlightBooking(ana.getId(), dl222.getId()),
                    new FlightBooking(jennifer.getId(), dl222.getId()),
                    new FlightBooking(christian.getId(), dl222.getId()),
                    new FlightBooking(christian.getId(), dl37.getId())
            ));

            log.info("Seeded {} customers, {} flights, {} bookings",
                    customerRepo.count(), flightRepo.count(), bookingRepo.count());

            log.info("findByStatus(GOLD):");
            customerRepo.findByStatus(CustomerStatus.GOLD).forEach(c -> log.info("  {}", c));

            log.info("findByCustomerId({}) [Tom Jones]:", tom.getId());
            bookingRepo.findByCustomerId(tom.getId()).forEach(b -> log.info("  {}", b));

            log.info("findByFlightId({}) [DL222]:", dl222.getId());
            bookingRepo.findByFlightId(dl222.getId()).forEach(b -> log.info("  {}", b));

            log.info("findByTotalCustomerMileageGreaterThan(100000):");
            customerRepo.findByTotalCustomerMileageGreaterThan(100000).forEach(c -> log.info("  {}", c));
        };
    }
}
