package com.lab_S7.flightbooking;

import com.lab_S7.flightbooking.model.*;
import com.lab_S7.flightbooking.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FlightbookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightbookingApplication.class, args);
	}

	@Bean
	CommandLineRunner run(CustomerRepository customerRepo,
						  FlightRepository flightRepo,
						  FlightBookingRepository bookingRepo) {
		return args -> {

			Customer alice = customerRepo.save(new Customer("Alice", CustomerStatus.GOLD, 120000));
			Customer tom = customerRepo.save(new Customer("Tom", CustomerStatus.SILVER, 80000));
			Customer jessica = customerRepo.save(new Customer("Jessica", CustomerStatus.NONE, 5000));

			Flight flight1 = flightRepo.save(new Flight("DL143", "Boeing 747", 400, 135));
			Flight flight2 = flightRepo.save(new Flight("DL122", "Airbus A330", 236, 4370));

			bookingRepo.save(new FlightBooking(alice.getId(), flight1.getId()));
			bookingRepo.save(new FlightBooking(tom.getId(), flight1.getId()));
			bookingRepo.save(new FlightBooking(jessica.getId(), flight2.getId()));
		};
	}
}
