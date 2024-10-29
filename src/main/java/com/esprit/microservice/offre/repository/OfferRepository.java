package com.esprit.microservice.offre.repository;

import com.esprit.microservice.offre.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfferRepository extends JpaRepository<Offer, Long> {
    List<Offer> findByDomainContainingIgnoreCase(String domain);
}
