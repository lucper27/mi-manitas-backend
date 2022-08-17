package com.lucasoft.mimanitas.infraestructure.rest;

import com.lucasoft.mimanitas.application.dto.OfferDTO;
import com.lucasoft.mimanitas.application.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OfferRestController {

    private final OfferService offerService;

    @Autowired
    public OfferRestController(OfferService offerService) {
        this.offerService = offerService;
    }

    @CrossOrigin
    @GetMapping(value = "/offers", produces = "application/json")
    public ResponseEntity<List<OfferDTO>> getAllOffers() {
        List<OfferDTO> allOffersDTO = this.offerService.getAllOffers();

        return new ResponseEntity<List<OfferDTO>>(allOffersDTO, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/offers/{offerID}", produces = "application/json")
    public ResponseEntity<OfferDTO> getOfferByID(@PathVariable Long offerID) {
        OfferDTO offerDTO = this.offerService.getOfferById(offerID);

        return new ResponseEntity<>(offerDTO, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/offers/{professionalID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<OfferDTO> saveAndAddToProfessional(@PathVariable Long professionalID,
                                                             @RequestBody OfferDTO offerDTO) {
        OfferDTO savedOfferDTO = this.offerService.saveOfferInProfessional(offerDTO, professionalID);

        return new ResponseEntity<>(savedOfferDTO,HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/offers/professionaloffers/{professionalID}", produces = "application/json")
    public ResponseEntity<List<OfferDTO>> getOffersFromProfessional(@PathVariable Long professionalID) {
        List<OfferDTO> offers = this.offerService.getOffersFromProfessional(professionalID);

        return new ResponseEntity<List<OfferDTO>>(offers,HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping(value = "/offers/{offerId}")
    public ResponseEntity<?> deleteOfferById(@PathVariable Long offerId) {
        this.offerService.deleteOfferById(offerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
