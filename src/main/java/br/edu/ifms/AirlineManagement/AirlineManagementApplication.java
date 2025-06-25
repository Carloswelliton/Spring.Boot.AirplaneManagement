package br.edu.ifms.AirlineManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.ifms.AirlineManagement.management.AirportManagement;

@SpringBootApplication
public class AirlineManagementApplication implements CommandLineRunner {

	@Autowired
	private AirportManagement airportManagement;
	

	public static void main(String[] args) {
		System.setProperty("java.awt.headless", "false");
		SpringApplication.run(AirlineManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		airportManagement.ShowMenu();
		
	}
}
