package br.edu.ifms.AirlineManagement.controller;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.ifms.AirlineManagement.models.Airplane;
import br.edu.ifms.AirlineManagement.repository.AirplaneRepository;
import br.edu.ifms.AirlineManagement.service.AirplaneService;

@Component
public class AirplaneController {
  @Autowired
  private AirplaneService airplaneService;
  @Autowired
  AirplaneRepository airplaneRepository;

  public void create(Airplane airplane){
    airplaneService.create(airplane);
    JOptionPane.showMessageDialog(null, "Registro criado","\t\t\tAtenção\t\t\t",JOptionPane.WARNING_MESSAGE);
  }

  public void read() {
    List<Airplane> list = airplaneService.readAll();
    if (list.isEmpty()) {
        JOptionPane.showMessageDialog(null, "A lista está vazia", "Aviso", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String[] colunas = {"ID", "Modelo", "Fabricante", "Registro", "Ano de Fabricação", "Capacidade"};

    String[][] dados = new String[list.size()][colunas.length];

    for (int i = 0; i < list.size(); i++) {
        Airplane a = list.get(i);
        dados[i][0] = String.valueOf(a.getId_airplane());
        dados[i][1] = a.getModelo();
        dados[i][2] = a.getFabricante();
        dados[i][3] = String.valueOf(a.getRegistro());
        dados[i][4] = String.valueOf(a.getAnoDeFabricacao());
        dados[i][5] = String.valueOf(a.getCapacidadePassageiros());
    }

    JTable table = new JTable(dados, colunas);
    table.setEnabled(false); 
    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

    JScrollPane scrollPane = new JScrollPane(table);
    scrollPane.setPreferredSize(new java.awt.Dimension(700, 300));

    JOptionPane.showMessageDialog(null, scrollPane, "Lista de Aviões", JOptionPane.INFORMATION_MESSAGE);
}


  public void update(Airplane airplaneUpdated, Long id){

    Airplane airplane = airplaneRepository.findById(id).orElseThrow(()-> new RuntimeException("ID não encontrado"));
    airplane.setModelo(airplaneUpdated.getModelo());
    airplane.setRegistro(airplaneUpdated.getRegistro());
    airplane.setAnoDeFabricacao(airplaneUpdated.getAnoDeFabricacao());
    airplane.setFabricante(airplaneUpdated.getFabricante());
    airplane.setCapacidadePassageiros(airplaneUpdated.getCapacidadePassageiros());
    airplaneRepository.save(airplane);
    JOptionPane.showMessageDialog(null, "Registro atualizado");
  }

  public void delete(Long id){
    airplaneService.delete(id);
    JOptionPane.showMessageDialog(null, "Registro deletado");
  }

  

  
}
