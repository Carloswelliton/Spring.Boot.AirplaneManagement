package br.edu.ifms.AirlineManagement.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "voos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id_flight;

  @Column(nullable = false, length = 100)
  private String origem;

  @Column(nullable = false, length = 100)
  private String destino;

  @Column(nullable = false)
  private LocalDateTime dataDePartida;

  @Column(nullable = false)
  private LocalDateTime dataDeChegada;

  @ManyToOne
  @JoinColumn(name = "airplane_id", nullable = false)
  private Airplane airplane;

  @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Passenger> passageiros;
}
