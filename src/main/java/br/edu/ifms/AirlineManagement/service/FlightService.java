package br.edu.ifms.AirlineManagement.service;

import br.edu.ifms.AirlineManagement.models.Airplane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.edu.ifms.AirlineManagement.models.Flight;
import br.edu.ifms.AirlineManagement.repository.FlightRepository;

import javax.swing.*;

@Service
public class FlightService extends GenericService<Flight, Long>{
  @Autowired
  private FlightRepository flightRepository;

  @Override
  protected JpaRepository<Flight, Long> getRepository() {
    return flightRepository;
  }

  @Override
  public Flight update(Long id, Flight updatedFlight) {

    Flight flight = flightRepository.findById(id).orElseThrow(()-> new RuntimeException("ID não encontrado"));
    flight.setOrigem(updatedFlight.getOrigem());
    flight.setDestino(updatedFlight.getDestino());
    flight.setDataDePartida(updatedFlight.getDataDePartida());
    flight.setDataDeChegada(updatedFlight.getDataDeChegada());
    JOptionPane.showMessageDialog(null, "Registro atualizado");
    return flightRepository.save(flight);


  }
}
