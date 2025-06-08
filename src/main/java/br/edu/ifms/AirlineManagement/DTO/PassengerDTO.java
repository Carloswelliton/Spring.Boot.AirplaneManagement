package br.edu.ifms.AirlineManagement.DTO;

import br.edu.ifms.AirlineManagement.models.Flight;

import java.util.Date;

public record PassengerDTO(String name,
                           String cpf,
                           Date dataDeNascimento,
                           String passportNumber,
                           long id_flight) {
}
