package dev.thallesborges.EllegancyNFSE;

import org.springframework.boot.SpringApplication;

public class TestEllegancyNfseApplication {

	public static void main(String[] args) {
		SpringApplication.from(EllegancyNfseApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
