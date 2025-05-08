package org.ironhack.labs_semana_7.repository;

import org.ironhack.labs_semana_7.enums.CustomerStatus;
import org.ironhack.labs_semana_7.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    // Método de consulta para buscar clientes por estado
    List<Customer>findByStatus(CustomerStatus status);

    //Añade un método en CustomerRepository para buscar clientes con más de 100.000 millas.
    List<Customer> findByTotalMileageGreaterThan(int mileage);
}
