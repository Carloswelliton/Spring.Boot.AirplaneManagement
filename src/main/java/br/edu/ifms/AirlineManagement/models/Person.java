package br.edu.ifms.AirlineManagement.models;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Table(name = "passageiros")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_pessoa", discriminatorType = DiscriminatorType.STRING)
public abstract class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id_person;

  @Column(name = "nome", nullable=false)
  private String name;

  @Column(nullable = false)
  private String cpf;

  @Column(name = "data_de_nascimento", nullable=false)
  private LocalDateTime dataDeNascimento;

}
