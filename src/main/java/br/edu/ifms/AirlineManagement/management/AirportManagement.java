package br.edu.ifms.AirlineManagement.management;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.ifms.AirlineManagement.controller.AirplaneController;
import br.edu.ifms.AirlineManagement.models.Airplane;

@Component
public class AirportManagement {

  @Autowired
  private AirplaneController airplaneController;

  public void ShowMenu(){

    var option =0;

    do{
      option =Integer.parseInt( JOptionPane.showInputDialog(null, """
        Bem vindo ao sistema de gerenciamente de vôos
        Por favor digite uma das opções abaixo
        [1] - Aviões
        [2] - Vôos
        [3] - Passageiros
        [0] - Sair
      """));
      switch (option) {
        case 1:
          menuAviao();
          break;
        case 2:
          break;
        case 3:
          break;
        case 0:
          JOptionPane.showMessageDialog(null, "Saindo...",null,JOptionPane.WARNING_MESSAGE);
          break;
        default:
          JOptionPane.showMessageDialog(null, "Digite uma opção válida", "Atenção", JOptionPane.ERROR_MESSAGE);
          break;
      }
      

    }while(option!=0);
  }
  
  public void menuAviao(){
    var opcao = 0;
        do{
        opcao = Integer.parseInt(JOptionPane.showInputDialog(null, """
          [1] - cadastrar avião
          [2] - listar aviões
          [3] - atualizar avião
          [4] - deletar avião
          [0] - sair
        """));

        switch(opcao){
          case 1:
            cadastrarAviao();
            break;
          case 2:
            airplaneController.read();
            break;
          case 3:
            try{
              Airplane airplaneUpdated = new Airplane();
              airplaneController.read();
              Long id = Long.parseLong(JOptionPane.showInputDialog(null,"Digite o ID do avião que deseja alterar"));
              airplaneUpdated.setModelo(JOptionPane.showInputDialog(null,"Digite o modelo do avião"));
              airplaneUpdated.setRegistro(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número do registro")));
              airplaneUpdated.setAnoDeFabricacao(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ano de fabricação")));
              airplaneUpdated.setFabricante(JOptionPane.showInputDialog(null, "Digite a fabricante"));
              airplaneUpdated.setCapacidadePassageiros(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a capacidade de passageiros")));
              airplaneController.update(airplaneUpdated, id);
            } catch(Exception e){
              e.getMessage();
            }
            break;
          case 4:
            airplaneController.read();
            Long id = Long.parseLong(JOptionPane.showInputDialog(null, "Digite o id do avião a ser deletado"));
            airplaneController.delete(id);
            break;
          case 0:
            JOptionPane.showMessageDialog(null, "Saindo...",null,JOptionPane.WARNING_MESSAGE);
            break;
          default:
            JOptionPane.showMessageDialog(null, "Digite uma opção válida", "Atenção", JOptionPane.ERROR_MESSAGE);
            break;

        }

      }while(opcao!=0);
  }

  public void cadastrarAviao(){
    JOptionPane.showMessageDialog(null, "Vamos cadastrar um avião");
    Airplane airplane = new Airplane();
    try{
      airplane.setModelo(JOptionPane.showInputDialog(null, "Digite o modelo do avião"));
      airplane.setRegistro(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o registor do avião")));
      airplane.setAnoDeFabricacao(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ano do avião")));
      airplane.setCapacidadePassageiros(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a capacidade de passageiros do avião ")));
      airplane.setFabricante(JOptionPane.showInputDialog(null, "Digite o fabricante"));
      airplaneController.create(airplane);
    }catch(Exception e){
      JOptionPane.showMessageDialog(null, e.getMessage());
    }
  }
}
