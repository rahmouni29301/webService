package com.esprit.microservice.offre.OfferController;

import com.esprit.microservice.offre.entity.Offer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.esprit.microservice.offre.serviceIterface.IOfferService;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("offer")
public class OfferController {
    IOfferService iOfferService;

    @PostMapping("/addOffer")
    public ResponseEntity<Long> addOffer(@RequestBody Offer offer) {
        Offer response = iOfferService.addOffer(offer);
        return ResponseEntity.ok(response.getIdOffer());
    }

    @GetMapping("/getAllOffers")
    public List<Offer> retrieveOffers() {
        return iOfferService.retrieveOffers();
    }

    @PutMapping("/updateOffer")
    public Offer updateOffer(@RequestBody Offer offer) {
        return iOfferService.updateOffer(offer);
    }

    @GetMapping("/retrieveOffer/{idOffer}")
    public Offer retrieveOffer(@PathVariable("idOffer") Long idOffer) {
        return iOfferService.retrieveOffer(idOffer);
    }

    @DeleteMapping("/removeOffer/{idOffer}")
    public void removeOffer(@PathVariable("idOffer") Long idOffer) {
        iOfferService.removeOffer(idOffer);
    }

    @GetMapping("/retrieveOfferByDomain/{domain}")
    public List<Offer> getOfferByDomain(@PathVariable("domain") String domain) {
        return iOfferService.getOfferByDomain(domain);
    }
}
