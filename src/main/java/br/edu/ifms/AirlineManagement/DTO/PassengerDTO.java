package br.edu.ifms.AirlineManagement.DTO;


import java.time.LocalDateTime;


public record PassengerDTO(String name,
                           String cpf,
                           LocalDateTime dataDeNascimento,
                           String passportNumber,
                           long id_flight) {
}
