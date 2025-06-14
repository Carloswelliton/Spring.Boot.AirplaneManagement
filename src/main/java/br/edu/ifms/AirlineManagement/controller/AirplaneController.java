package br.edu.ifms.AirlineManagement.controller;

import java.util.List;

import javax.swing.Icon;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.ifms.AirlineManagement.models.Airplane;
import br.edu.ifms.AirlineManagement.service.AirplaneService;

@Component
public class AirplaneController {
  @Autowired
  private AirplaneService airplaneService;

  public void create(Airplane airplane){
    airplaneService.create(airplane);
    JOptionPane.showMessageDialog(null, "Registro criado","\t\t\tAtenção\t\t\t",JOptionPane.WARNING_MESSAGE);
  }

  public void read(){
    List<Airplane> list = airplaneService.readAll();
    if(list.isEmpty()){
      JOptionPane.showMessageDialog(null, "A lista está vazia", null, JOptionPane.ERROR_MESSAGE);
      return;
    }
    StringBuilder sb = new StringBuilder();

    for(Airplane a: list){
      sb.append("ID: ").append(a.getId_airplane()).append("\n");
      sb.append("Modelo: ").append(a.getModelo()).append("\n");
      sb.append("Fabricante: ").append(a.getFabricante()).append("\n");
      sb.append("Registro: ").append(a.getRegistro()).append("\n");
      sb.append("Ano de fabricação: ").append(a.getAnoDeFabricacao()).append("\n");
      sb.append("Capacidade de passageiros: ").append(a.getCapacidadePassageiros()).append("\n");
      sb.append("----------------------\n");
    }
    JOptionPane.showMessageDialog(null, sb.toString());
  }

  public void update(Airplane airplaneUpdated, Long id){
    airplaneService.update(id, airplaneUpdated);
    JOptionPane.showMessageDialog(null, "Registro atualizado");
  }

  public void delete(Long id){
    airplaneService.delete(id);
    JOptionPane.showMessageDialog(null, "Registro deletado");
  }

  

  
}
