package org.ironhack.labs_semana_7.service;

import org.ironhack.labs_semana_7.enums.CustomerStatus;
import org.ironhack.labs_semana_7.model.Customer;
import org.ironhack.labs_semana_7.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customersRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customersRepository = customerRepository;
    }

    public List<Customer> findCustomersByStatus(CustomerStatus status){
        return customersRepository.findByStatus(status);
    }

    public List<Customer>getHighMileageCustomer(){
        return customersRepository.findByTotalMileageGreaterThan(100000);
    }




}
