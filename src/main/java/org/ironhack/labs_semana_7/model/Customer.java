package org.ironhack.labs_semana_7.model;

import jakarta.persistence.*;
import org.ironhack.labs_semana_7.enums.CustomerStatus;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    //Hacemos uso de nuestro enum.
    @Enumerated(EnumType.STRING)
    private CustomerStatus status;

    private Integer totalMileage;


    public Customer(String name, CustomerStatus status, Integer totalMileage) {

        this.name = name;
        this.status = status;
        this.totalMileage = totalMileage;
    }

    //Constructor vacio
    public Customer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustomerStatus getStatus() {
        return status;
    }

    public void setStatus(CustomerStatus status) {
        this.status = status;
    }

    public Integer getTotalMileage() {
        return totalMileage;
    }

    public void setTotalMileage(Integer totalMileage) {
        this.totalMileage = totalMileage;
    }



}
