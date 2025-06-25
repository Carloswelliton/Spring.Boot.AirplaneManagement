package br.edu.ifms.AirlineManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifms.AirlineManagement.models.Flight;
import org.springframework.stereotype.Repository;


public interface FlightRepository extends JpaRepository<Flight, Long>{}
