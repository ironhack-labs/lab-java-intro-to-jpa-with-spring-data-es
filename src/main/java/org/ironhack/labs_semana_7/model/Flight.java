package org.ironhack.labs_semana_7.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String fligthName; //Numero de vuelo

    private String aircraft; //aeronave

    private Integer numberSeats; //Número totales de asientos

    private Integer flightDistance; //Distancia del vuelo


    public Flight(String fligthName, String aircraft, Integer numberSeats, Integer flightDistance) {

        this.fligthName = fligthName;
        this.aircraft = aircraft;
        this.numberSeats = numberSeats;
        this.flightDistance = flightDistance;
    }

    public Flight() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFligthName() {
        return fligthName;
    }

    public void setFligthName(String fligthName) {
        this.fligthName = fligthName;
    }

    public String getAircraft() {
        return aircraft;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }

    public Integer getNumberSeats() {
        return numberSeats;
    }

    public void setNumberSeats(Integer numberSeats) {
        this.numberSeats = numberSeats;
    }

    public Integer getFlightDistance() {
        return flightDistance;
    }

    public void setFlightDistance(Integer flightDistance) {
        this.flightDistance = flightDistance;
    }
}
