package com.esprit.microservice.offre;

import com.esprit.microservice.offre.entity.Review;
import com.esprit.microservice.offre.repository.ReviewRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class ReviewApplication {

	private final ReviewRepository reviewRepository;

	public ReviewApplication(ReviewRepository reviewRepository) {
		this.reviewRepository = reviewRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ReviewApplication.class, args);
	}

	@Bean
	ApplicationRunner init() {
		return (args) -> {
			// Add some default reviews for testing purposes
			List<Review> defaultReviews = List.of(
					new Review(null, "Excellent service and timely support", 5),
					new Review(null, "Satisfied with the product quality", 4),
					new Review(null, "Could improve the user interface", 3)
			);

			// Save the default reviews to the database
			reviewRepository.saveAll(defaultReviews);

			// Print all reviews to verify
			reviewRepository.findAll().forEach(System.out::println);
		};
	}
}
