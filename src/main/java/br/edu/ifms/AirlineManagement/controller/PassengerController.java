package br.edu.ifms.AirlineManagement.controller;

import java.util.List;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.ifms.AirlineManagement.models.Passenger;
import br.edu.ifms.AirlineManagement.service.PassengerService;

@Component
public class PassengerController {
  @Autowired
  private PassengerService passengerService;

  public void create(Passenger passenger){
    passengerService.create(passenger);
    JOptionPane.showMessageDialog(null, "Registro criado");
  }

  public void update(Long id, Passenger passengerUpdated){
    passengerService.update(id, passengerUpdated);
    JOptionPane.showMessageDialog(null, "Registro atualizado");
  }

  public void delete(Long id){
    passengerService.delete(id);
    JOptionPane.showMessageDialog(null, "Registro deletado");
  }

  public void read(){
    List<Passenger> list = passengerService.readAll();
    if(list.isEmpty()){
      JOptionPane.showMessageDialog(null, "Lista está vazia");
      return;
    }
    StringBuilder sb = new StringBuilder();

    for(Passenger p : list){
      sb.append("Nome: ").append(p.getName()).append("\n");
      sb.append("CPF: ").append(p.getCpf()).append("\n");
      sb.append("Número do passaporte: ").append((p.getPassportNumber())).append("\n");
      sb.append("Data de nascimento: ").append(p.getDataDeNascimento()).append("\n");
      if (p.getFlight() == null) {
        sb.append("Nenhum vôo para este passageiro");
      }else{
        sb.append("Vôo: ").append(p.getFlight()).append("\n");
      }
      sb.append("---------------------------------\n");
    }
    JOptionPane.showMessageDialog(null, sb.toString());

  }
}
