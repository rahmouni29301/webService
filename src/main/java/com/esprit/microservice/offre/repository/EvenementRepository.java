package com.esprit.microservice.offre.repository;

import com.esprit.microservice.offre.entity.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EvenementRepository extends JpaRepository<Evenement, Long> {
    List<Evenement> findByNomContainingIgnoreCase(String nom);
}