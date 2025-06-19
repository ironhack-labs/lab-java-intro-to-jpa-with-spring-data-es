package com.lab_S7.flightbooking.model;

import jakarta.persistence.*;

@Entity
public class FlightBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;
    private Long flightId;

    public FlightBooking() {
    }

    public FlightBooking(Long customerId, Long flightId) {
        this.customerId = customerId;
        this.flightId = flightId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }
}