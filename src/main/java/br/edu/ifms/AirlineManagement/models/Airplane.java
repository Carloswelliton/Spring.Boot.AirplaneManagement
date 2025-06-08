package br.edu.ifms.AirlineManagement.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "avioes")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Airplane {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id_airplane;

  @Column(nullable = false)
  private String modelo;

  @Column(nullable = false)
  private String fabricante;

  @Column(nullable = false)
  private int capacidadePassageiros;

  @Column(nullable = false)
  private int anoDeFabricacao;

  @Column(nullable = false)
  private int registro;
}
