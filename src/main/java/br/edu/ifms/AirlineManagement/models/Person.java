package br.edu.ifms.AirlineManagement.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Entity
@Table(name="passageiros  ")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo_pessoa", discriminatorType=DiscriminatorType.STRING)
public abstract class Person {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private long id_person;

  @Column(name="nome")
  private String name;

  @Column
  private String cpf;

  @Column(name="data_de_nascimento")
  private Date dataDeNascimento;

}
