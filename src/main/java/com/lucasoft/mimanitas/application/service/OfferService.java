package com.lucasoft.mimanitas.application.service;


import com.lucasoft.mimanitas.application.dto.OfferDTO;
import java.util.List;

public interface OfferService {

    OfferDTO saveOfferInProfessional(OfferDTO offerDTO, Long professionalID);

    List<OfferDTO> getAllOffers();

    OfferDTO getOfferById(Long id);

    List<OfferDTO> getOffersFromProfessional(Long professionalID);

    void deleteOfferById(Long offerId);
}
