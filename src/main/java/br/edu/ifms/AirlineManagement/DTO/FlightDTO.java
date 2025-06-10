package br.edu.ifms.AirlineManagement.DTO;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public record FlightDTO(String origem,
                        String destino,
                        LocalDateTime dataDePartida,
                        LocalDateTime dataDeChegada,
                        Long id_airplane,
                        List<Long> passageirosIds) {}
