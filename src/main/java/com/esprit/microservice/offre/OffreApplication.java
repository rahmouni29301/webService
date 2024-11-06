package com.esprit.microservice.offre;

import com.esprit.microservice.offre.entity.CallForTender;
import com.esprit.microservice.offre.repository.COTrepo;
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
	private COTrepo offerRepository;  // Injection du dépôt COTrepo

	public static void main(String[] args) {
		SpringApplication.run(OffreApplication.class, args);
	}

	@Bean
	ApplicationRunner init() {
		return (args) -> {
			// Ajoutez quelques offres par défaut avec les nouveaux champs
			offerRepository.save(new CallForTender(
					1,  // L'ID est généré automatiquement
					"Création d'un site vitrine",
					100L,  // Quantité par défaut
					"Développement Web",
					"site_vitrine.pdf"  // Nom du fichier PDF par défaut
			));
			offerRepository.save(new CallForTender(
					55,  // L'ID est généré automatiquement
					"Campagne SEO et SEM",
					200L,  // Quantité par défaut
					"Marketing Digital",
					"seo_sem.pdf"  // Nom du fichier PDF par défaut
			));
			offerRepository.save(new CallForTender(
					4,  // L'ID est généré automatiquement
					"Amélioration de l'expérience utilisateur",
					50L,   // Quantité par défaut
					"Design UX/UI",
					"ux_ui_design.pdf"  // Nom du fichier PDF par défaut
			));

			// Affichez toutes les offres pour vérifier
			offerRepository.findAll().forEach(System.out::println);
		};
	}
}
