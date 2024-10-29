package com.esprit.microservice.offre;

import com.esprit.microservice.offre.entity.Offer;
import com.esprit.microservice.offre.entity.TypeOffer;
import com.esprit.microservice.offre.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
@EnableDiscoveryClient
public class OffreApplication {
	@Autowired
	private OfferRepository offerRepository;

	public static void main(String[] args) {
		SpringApplication.run(OffreApplication.class, args);
	}


@Bean
ApplicationRunner init() {
	return (args) -> {
		// Ajoutez quelques offres par défaut
		offerRepository.save(new Offer("Développement Web", "Création d'un site vitrine", LocalDate.now(), "Informatique", TypeOffer.JOB));
		offerRepository.save(new Offer("Marketing Digital", "Campagne SEO et SEM", LocalDate.now(), "Marketing", TypeOffer.JOB));
		offerRepository.save(new Offer("Design UX/UI", "Amélioration de l'expérience utilisateur", LocalDate.now(), "Design", TypeOffer.JOB));

		// Affichez toutes les offres pour vérifier
		offerRepository.findAll().forEach(System.out::println);
	};
}
}