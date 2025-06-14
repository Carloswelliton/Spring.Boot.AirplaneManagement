package br.edu.ifms.AirlineManagement.controller;

import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.ifms.AirlineManagement.models.Flight;
import br.edu.ifms.AirlineManagement.models.Passenger;
import br.edu.ifms.AirlineManagement.service.FlightService;

@Component
public class FlightController {
  @Autowired
  private FlightService flightService;

  public void create(Flight flight){
    flightService.create(flight);
    JOptionPane.showMessageDialog(null, "Registro criado");
  }

  public void delete(Long id){
    flightService.delete(id);
    JOptionPane.showMessageDialog(null, "Registro excluido");
  }

  public void update(Flight flight, Long id){
    flightService.update(id, flight);
    JOptionPane.showMessageDialog(null, "Registro alterado");
  }

  public void read(){
    List<Flight> list = flightService.readAll();
    if(list.isEmpty()){
      JOptionPane.showMessageDialog(null, "A lista está vazia");
      return;
    }

    StringBuilder sb = new StringBuilder();

    for(Flight f: list){
      sb.append("ID: ").append(f.getId_flight()).append("\n");
      sb.append("Origem: ").append(f.getOrigem()).append("\n");
      sb.append("Destino: ").append(f.getDestino()).append("\n");
      sb.append("Data de partida: ").append(f.getDataDePartida()).append("\n");
      sb.append("Data de chegada: ").append(f.getDataDeChegada()).append("\n");
      sb.append("Avião: ").append(f.getAirplane().getModelo()).append("Registro: ").append(f.getAirplane().getRegistro()).append("\n");
      sb.append("----------------------\n");

      Set<Passenger> passengers = f.getPassageiros();
      if(passengers.isEmpty()){
        sb.append("Nenhum passageiro cadastro nesse vôo\n");
      }else{
        sb.append("Passageiros: \n");
        for(Passenger p : passengers){
          sb.append("Nome: ").append(p.getName())
            .append(", CPF: ").append(p.getCpf())
            .append(", Passaporte: ").append(p.getPassportNumber());
        }
      }
    }

    JOptionPane.showMessageDialog(null, sb.toString());
  }




}
