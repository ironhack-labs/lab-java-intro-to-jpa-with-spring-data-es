package com.ironhack.airlinebooking.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    // Stored as the enum name ("GOLD") rather than its ordinal, so reordering
    // the enum constants can never silently change existing rows.
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CustomerStatus status;

    @Column(name = "total_customer_mileage")
    private Integer totalCustomerMileage;

    /** Required by JPA. */
    protected Customer() {
    }

    public Customer(String name, CustomerStatus status, Integer totalCustomerMileage) {
        this.name = name;
        this.status = status;
        this.totalCustomerMileage = totalCustomerMileage;
    }

    public Integer getId() {
        return id;
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

    public Integer getTotalCustomerMileage() {
        return totalCustomerMileage;
    }

    public void setTotalCustomerMileage(Integer totalCustomerMileage) {
        this.totalCustomerMileage = totalCustomerMileage;
    }

    @Override
    public String toString() {
        return "Customer{id=" + id + ", name='" + name + "', status=" + status
                + ", totalCustomerMileage=" + totalCustomerMileage + "}";
    }
}
