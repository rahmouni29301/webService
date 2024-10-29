package com.esprit.microservice.offre.Controller;

import com.esprit.microservice.offre.entity.Evenement;
import com.esprit.microservice.offre.serviceIterface.IEvenementService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("evenement")
public class EvenementController {
    IEvenementService iEvenementService;

    @PostMapping("/addEvenement")
    public ResponseEntity<Long> addEvenement(@RequestBody Evenement evenement) {
        Evenement response = iEvenementService.addEvenement(evenement);
        return ResponseEntity.ok(response.getIdEvenement());
    }

    @GetMapping("/getAllEvenements")
    public List<Evenement> retrieveEvenements() {
        return iEvenementService.retrieveEvenements();
    }

    @PutMapping("/updateEvenement")
    public Evenement updateEvenement(@RequestBody Evenement evenement) {
        return iEvenementService.updateEvenement(evenement);
    }

    @GetMapping("/retrieveEvenement/{idEvenement}")
    public Evenement retrieveEvenement(@PathVariable("idEvenement") Long idEvenement) {
        return iEvenementService.retrieveEvenement(idEvenement);
    }

    @DeleteMapping("/removeEvenement/{idEvenement}")
    public void removeEvenement(@PathVariable("idEvenement") Long idEvenement) {
        iEvenementService.removeEvenement(idEvenement);
    }

    @GetMapping("/retrieveEvenementByNom/{nom}")
    public List<Evenement> getEvenementByNom(@PathVariable("nom") String nom) {
        return iEvenementService.getEvenementByNom(nom);
    }
}