package br.edu.ifms.AirlineManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.edu.ifms.AirlineManagement.models.Airplane;
import br.edu.ifms.AirlineManagement.repository.AirplaneRepository;

@Service
public class AirplaneService extends GenericService<Airplane, Long> {
  @Autowired
  private AirplaneRepository airplaneRepository;  

  @Override
  protected JpaRepository<Airplane, Long>getRepository(){
    return airplaneRepository;
  }
}
