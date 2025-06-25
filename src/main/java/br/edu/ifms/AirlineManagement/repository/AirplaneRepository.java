package br.edu.ifms.AirlineManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifms.AirlineManagement.models.Airplane;
import org.springframework.stereotype.Repository;


public interface AirplaneRepository extends JpaRepository<Airplane, Long>{}
