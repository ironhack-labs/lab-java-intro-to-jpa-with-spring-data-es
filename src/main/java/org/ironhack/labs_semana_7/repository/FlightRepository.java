package org.ironhack.labs_semana_7.repository;

import org.ironhack.labs_semana_7.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

}
