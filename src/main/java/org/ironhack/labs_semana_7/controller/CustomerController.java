package org.ironhack.labs_semana_7.controller;

import org.ironhack.labs_semana_7.enums.CustomerStatus;
import org.ironhack.labs_semana_7.model.Customer;
import org.ironhack.labs_semana_7.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    //Inyeccion por dependencia mediante constructor
    private CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }


    @GetMapping("/status")
    public List<Customer> getCustomersByStatus(@RequestParam CustomerStatus status) {
        return customerService.findCustomersByStatus(status); // Asegúrate de que exista este método en CustomerService
    }

    @GetMapping("/highMileage")
    public List<Customer> getHighMileageCustomers() {
        return customerService.getHighMileageCustomer();
    }




}
