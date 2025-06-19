package com.lab_S7.flightbooking.controller;

import com.lab_S7.flightbooking.model.Customer;
import com.lab_S7.flightbooking.model.CustomerStatus;
import com.lab_S7.flightbooking.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerRepository customerRepo;

    public CustomerController(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    @GetMapping("/status/{status}")
    public List<Customer> getCustomersByStatus(@PathVariable CustomerStatus status) {
        return customerRepo.findByStatus(status);
    }
}
