package com.esprit.microservice.offre;

import com.esprit.microservice.offre.entity.*;
import com.esprit.microservice.offre.repository.EvenementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
@EnableDiscoveryClient
public class EvenementApplication {

	@Autowired
	private EvenementRepository evenementRepository ;

	public static void main(String[] args) {
		SpringApplication.run(EvenementApplication.class, args);
	}


@Bean
ApplicationRunner init() {
	return (args) -> {

		/////////////////evenemen//////////////////////
		// Save default events
		evenementRepository.save(new Evenement("Développement Web", LocalDate.now(), "Création d'un site vitrine"));
		evenementRepository.save(new Evenement("Marketing Digital", LocalDate.now(), "Campagne SEO et SEM"));
		evenementRepository.save(new Evenement("Design UX/UI", LocalDate.now(), "Amélioration de l'expérience utilisateur"));
		evenementRepository.save(new Evenement("Séminaire sur l'Innovation", LocalDate.now().plusDays(10), "Discussion sur les nouvelles technologies"));

		// Display all events to verify
		evenementRepository.findAll().forEach(System.out::println);
	};


	}


}


