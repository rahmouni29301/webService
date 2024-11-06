package com.esprit.microservice.offre.repository;

import com.esprit.microservice.offre.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
