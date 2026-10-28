package dev.thallesborges.EllegancyNFSE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EllegancyNfseApplication {

	public static void main(String[] args) {
		SpringApplication.run(EllegancyNfseApplication.class, args);
	}

}
