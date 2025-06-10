package br.edu.ifms.AirlineManagement.DTO;

import br.edu.ifms.AirlineManagement.models.Flight;

import java.time.LocalDateTime;
import java.util.Date;

public record PassengerDTO(String name,
                           String cpf,
                           LocalDateTime dataDeNascimento,
                           String passportNumber,
                           long id_flight) {
}
