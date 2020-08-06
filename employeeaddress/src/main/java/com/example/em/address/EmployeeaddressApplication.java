package com.example.em.address;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EmployeeaddressApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeaddressApplication.class, args);
	}

}
