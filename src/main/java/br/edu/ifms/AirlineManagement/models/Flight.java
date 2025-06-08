package br.edu.ifms.AirlineManagement.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "voos")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Flight {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id_flight;

  @Column(nullable = false)
  private String origem;

  @Column(nullable = false)
  private String destino;

  @Column(nullable = false)
  private Date dataDePartida;

  @Column(nullable = false)
  private Date dataDeChegada;

  @ManyToOne
  @JoinColumn(name = "airplane_id", nullable = false)
  private Airplane airplane;

  @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Passenger> passageiros;
}
