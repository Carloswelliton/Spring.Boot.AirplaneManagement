package br.edu.ifms.AirlineManagement.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@DiscriminatorValue("passageiro")
public class Passenger extends Person{

  @Column(nullable=false, unique=true)
  private String passportNumber;

  @ManyToOne
  @JoinColumn(name="flight_id", nullable=false)
  private Flight flight;



}
