package com.example.create_project_JPA;

import jakarta.persistence.EntityManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CreateProjectJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreateProjectJpaApplication.class, args);
	}
	EntityManager entityManager;
}
