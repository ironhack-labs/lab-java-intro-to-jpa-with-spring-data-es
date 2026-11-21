package com.ironhack.airlinebooking.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * A customer's seat on a flight.
 * <p>
 * The lab asks for plain foreign-key columns for now, so this entity stores the
 * customer and flight ids directly instead of mapping {@code @ManyToOne} relations.
 */
@Entity
@Table(name = "flight_bookings")
public class FlightBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "customer_id", nullable = false)
    private Integer customerId;

    @Column(name = "flight_id", nullable = false)
    private Integer flightId;

    /** Required by JPA. */
    protected FlightBooking() {
    }

    public FlightBooking(Integer customerId, Integer flightId) {
        this.customerId = customerId;
        this.flightId = flightId;
    }

    public Integer getId() {
        return id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    @Override
    public String toString() {
        return "FlightBooking{id=" + id + ", customerId=" + customerId + ", flightId=" + flightId + "}";
    }
}
