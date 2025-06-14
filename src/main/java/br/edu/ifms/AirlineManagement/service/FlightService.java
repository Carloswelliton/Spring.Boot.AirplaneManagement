package br.edu.ifms.AirlineManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.edu.ifms.AirlineManagement.models.Flight;
import br.edu.ifms.AirlineManagement.repository.FlightRepository;

@Service
public class FlightService extends GenericService<Flight, Long>{
  @Autowired
  private FlightRepository flightRepository;

  @Override
  protected JpaRepository<Flight, Long> getRepository() {
    return flightRepository;
  }

  
}
