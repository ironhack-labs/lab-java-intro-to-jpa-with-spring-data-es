package com.ironhack.airlinebooking.repository;

import com.ironhack.airlinebooking.model.Customer;
import com.ironhack.airlinebooking.model.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findByStatus(CustomerStatus status);

    /** Extra practice: customers who have flown more than {@code mileage} miles. */
    List<Customer> findByTotalCustomerMileageGreaterThan(Integer mileage);
}
