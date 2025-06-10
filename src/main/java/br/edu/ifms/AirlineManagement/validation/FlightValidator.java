package br.edu.ifms.AirlineManagement.validation;

import br.edu.ifms.AirlineManagement.DTO.FlightDTO;
import br.edu.ifms.AirlineManagement.exception.ValidationException;

public class FlightValidator {
  public static void validate(FlightDTO dto){
    if(dto.origem().equalsIgnoreCase(dto.destino())){
      throw new ValidationException("origem não pode ser igual ao destino");
    }
  }
}
