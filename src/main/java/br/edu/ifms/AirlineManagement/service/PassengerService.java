package br.edu.ifms.AirlineManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.edu.ifms.AirlineManagement.models.Passenger;
import br.edu.ifms.AirlineManagement.repository.PassengerRepository;

@Service
public class PassengerService extends GenericService<Passenger, Long>{
  @Autowired
  private PassengerRepository passengerRepository;

  @Override
  protected JpaRepository<Passenger, Long> getRepository() {
    return passengerRepository;
  }
}
