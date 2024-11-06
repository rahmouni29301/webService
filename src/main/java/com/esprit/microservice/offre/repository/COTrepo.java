package com.esprit.microservice.offre.repository;

import com.esprit.microservice.offre.entity.CallForTender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface COTrepo extends JpaRepository<CallForTender, Long> {
}