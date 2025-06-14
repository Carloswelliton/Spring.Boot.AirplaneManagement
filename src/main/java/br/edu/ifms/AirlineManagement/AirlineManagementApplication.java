package br.edu.ifms.AirlineManagement;

import br.edu.ifms.AirlineManagement.controller.AirplaneController;
import br.edu.ifms.AirlineManagement.service.VerifyInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AirlineManagementApplication implements CommandLineRunner {

	@Autowired
	private AirplaneController airline;

	public static void main(String[] args) {
		System.setProperty("java.awt.headless", "false");
		SpringApplication.run(AirlineManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		

	}
}
