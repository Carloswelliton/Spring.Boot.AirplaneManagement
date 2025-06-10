package br.edu.ifms.AirlineManagement;

import br.edu.ifms.AirlineManagement.service.VerifyInfo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AirlineManagementApplication implements CommandLineRunner {

	public static void main(String[] args) {
		System.setProperty("java.awt.headless", "false");
		SpringApplication.run(AirlineManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		VerifyInfo verify = new VerifyInfo();
		verify.cpfValidate("056.724.661-24");

	}
}
