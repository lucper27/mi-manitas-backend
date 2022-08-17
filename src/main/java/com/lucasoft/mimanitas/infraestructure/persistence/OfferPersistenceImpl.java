package com.lucasoft.mimanitas.infraestructure.persistence;

import com.lucasoft.mimanitas.domain.entity.Offer;
import com.lucasoft.mimanitas.domain.persistence.OfferPersistence;
import com.lucasoft.mimanitas.infraestructure.persistence.OfferRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OfferPersistenceImpl implements OfferPersistence {

    private final OfferRepository offerRepository;

    public OfferPersistenceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public Offer save(Offer offer) {
        return this.offerRepository.save(offer);
    }

    @Override
    public List<Offer> getallOffers() {
        return this.offerRepository.findAll();
    }

    @Override
    public Offer getOfferById(Long id) {
        return this.offerRepository.getOfferById(id);
    }

    @Override
    public void deleteOfferById(Long offerId) {
        this.offerRepository.deleteById(offerId);
    }
}
