package com.lucasoft.mimanitas.application.service.implementation;

import com.lucasoft.mimanitas.application.dto.OfferDTO;
import com.lucasoft.mimanitas.application.dto.ProfessionalDTO;
import com.lucasoft.mimanitas.application.mapper.OfferMapper;
import com.lucasoft.mimanitas.application.mapper.ProfessionalMapper;
import com.lucasoft.mimanitas.application.service.OfferService;
import com.lucasoft.mimanitas.application.service.ProfessionalService;
import com.lucasoft.mimanitas.domain.entity.Offer;
import com.lucasoft.mimanitas.domain.entity.Professional;
import com.lucasoft.mimanitas.domain.persistence.OfferPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferPersistence offerPersistence;

    private final OfferMapper offerMapper;

    private final ProfessionalService professionalService;

    @Autowired
    public OfferServiceImpl(OfferPersistence offerPersistence, OfferMapper offerMapper, ProfessionalService professionalService) {
        this.offerPersistence = offerPersistence;
        this.offerMapper = offerMapper;
        this.professionalService = professionalService;
    }

    @Override
    @Transactional
    public OfferDTO saveOfferInProfessional(OfferDTO offerDTO, Long professionalID) {
        addOfferToProfessional(offerDTO, professionalID);

        return offerDTO;
    }

    private void addOfferToProfessional(OfferDTO offerDTO, Long professionalID) {
        ProfessionalDTO professionalDTO = this.professionalService.getProfessionalById(professionalID);
        professionalDTO.getOffers().add(offerDTO);
        this.professionalService.save(professionalDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OfferDTO> getAllOffers() {
        List<Offer> offers = this.offerPersistence.getallOffers();
        return this.offerMapper.toDto(offers);
    }

    @Override
    @Transactional(readOnly = true)
    public OfferDTO getOfferById(Long id) {
        Offer offer = this.offerPersistence.getOfferById(id);
        return this.offerMapper.toDto(offer);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OfferDTO> getOffersFromProfessional(Long professionalID) {
        ProfessionalDTO professionalDTO = this.professionalService.getProfessionalById(professionalID);

        return professionalDTO.getOffers();
    }

    @Override
    public void deleteOfferById(Long offerId) {
        this.offerPersistence.deleteOfferById(offerId);
    }
}
