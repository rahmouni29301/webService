package com.esprit.microservice.offre.serviceIterface;

import com.esprit.microservice.offre.entity.Evenement;

import java.util.List;

public interface IEvenementService {
    Evenement addEvenement(Evenement evenement);
    List<Evenement> retrieveEvenements();
    Evenement updateEvenement(Evenement evenement);
    Evenement retrieveEvenement(Long idEvenement);
    void removeEvenement(Long idEvenement);
    List<Evenement> getEvenementByNom(String nom);
}
