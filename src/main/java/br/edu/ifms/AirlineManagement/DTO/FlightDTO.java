package br.edu.ifms.AirlineManagement.DTO;

import br.edu.ifms.AirlineManagement.models.Airplane;
import br.edu.ifms.AirlineManagement.models.Passenger;

import java.util.Date;
import java.util.List;

public record FlightDTO (String origem,
                         String destino,
                         Date dataDePartida,
                         Date dataDeChegada,
                         Long  id_airplane,
                         List<Long> passageirosId){
}
