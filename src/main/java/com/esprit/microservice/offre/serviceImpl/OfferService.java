package com.esprit.microservice.offre.serviceImpl;

import com.esprit.microservice.offre.entity.Offer;
import com.esprit.microservice.offre.serviceIterface.IOfferService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.esprit.microservice.offre.repository.OfferRepository;
import java.util.List;

@Service
@AllArgsConstructor
public class OfferService implements IOfferService {

    OfferRepository offerRepository;

    @Override
    public Offer addOffer(Offer offer) {
        return offerRepository.save(offer);
    }

    @Override
    public List<Offer> retrieveOffers() {
        return offerRepository.findAll();
    }

    @Override
    public Offer updateOffer(Offer offer) {
        return offerRepository.save(offer);
    }

    @Override
    public Offer retrieveOffer(Long idOffer) {
        return offerRepository.findById(idOffer).orElse(null);
    }

    @Override
    public void removeOffer(Long idOffer) {
        offerRepository.deleteById(idOffer);
    }

    @Override
    public List<Offer> getOfferByDomain(String domain) {
        return offerRepository.findByDomainContainingIgnoreCase(domain);
    }
}
