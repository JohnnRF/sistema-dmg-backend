package com.dmg.sistema_dmg_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SistemaDmgBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaDmgBackendApplication.class, args);
	}

}
