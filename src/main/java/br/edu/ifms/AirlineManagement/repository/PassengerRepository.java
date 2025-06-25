package br.edu.ifms.AirlineManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifms.AirlineManagement.models.Passenger;
import org.springframework.stereotype.Repository;


public interface PassengerRepository extends JpaRepository<Passenger, Long>{
  
}
