package com.esprit.microservice.offre.serviceImpl;


import com.esprit.microservice.offre.entity.Evenement;
import com.esprit.microservice.offre.repository.EvenementRepository;
import com.esprit.microservice.offre.serviceIterface.IEvenementService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EvenementService implements IEvenementService {

    EvenementRepository evenementRepository;

    @Override
    public Evenement addEvenement(Evenement evenement) {
        return evenementRepository.save(evenement);
    }

    @Override
    public List<Evenement> retrieveEvenements() {
        return evenementRepository.findAll();
    }

    @Override
    public Evenement updateEvenement(Evenement evenement) {
        return evenementRepository.save(evenement);
    }

    @Override
    public Evenement retrieveEvenement(Long idEvenement) {
        return evenementRepository.findById(idEvenement).orElse(null);
    }

    @Override
    public void removeEvenement(Long idEvenement) {
        evenementRepository.deleteById(idEvenement);
    }

    @Override
    public List<Evenement> getEvenementByNom(String nom) {
        return evenementRepository.findByNomContainingIgnoreCase(nom);
    }
}
