package com.lucasoft.mimanitas.domain.persistence;

import com.lucasoft.mimanitas.domain.entity.Offer;

import java.util.List;

public interface OfferPersistence {

    Offer save(Offer offer);

    List<Offer> getallOffers();

    Offer getOfferById(Long id);

    void deleteOfferById(Long offerId);
}
