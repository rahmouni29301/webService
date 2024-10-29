package com.esprit.microservice.offre.serviceIterface;

import com.esprit.microservice.offre.entity.Offer;

import java.util.List;

public interface IOfferService {
    Offer addOffer(Offer offer);
    List<Offer> retrieveOffers();
    Offer updateOffer(Offer offer);
    Offer retrieveOffer(Long idOffer);
    void removeOffer(Long idOffer);
    List<Offer> getOfferByDomain(String domain);
}