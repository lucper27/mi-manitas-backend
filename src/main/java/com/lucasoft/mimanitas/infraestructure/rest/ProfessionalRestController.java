package com.lucasoft.mimanitas.infraestructure.rest;

import com.lucasoft.mimanitas.application.dto.ProfessionalDTO;
import com.lucasoft.mimanitas.application.dto.SimpleProfessionalDTO;
import com.lucasoft.mimanitas.application.dto.TradeDTO;
import com.lucasoft.mimanitas.application.dto.ZoneDTO;
import com.lucasoft.mimanitas.application.service.ProfessionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfessionalRestController {

    private final ProfessionalService professionalService;

    @Autowired
    public ProfessionalRestController(ProfessionalService professionalService) {
        this.professionalService = professionalService;
    }

    @CrossOrigin
    @GetMapping(value = "/professionals", produces = "application/json")
    public ResponseEntity<List<ProfessionalDTO>> getAllProfessionals() {
        List<ProfessionalDTO> professionals = this.professionalService.getAllProfessionals();
        return new ResponseEntity<List<ProfessionalDTO>>(professionals, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/professionals/{professionalID}", produces = "application/json")
    public ResponseEntity<ProfessionalDTO> getProfessionalByID(@PathVariable Long professionalID) {
        ProfessionalDTO professionalDTO = this.professionalService.getProfessionalById(professionalID);
        return new ResponseEntity<>(professionalDTO, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/professionals", produces = "application/json", consumes = "application/json")
    public ResponseEntity<SimpleProfessionalDTO> addNewProfessional(@RequestBody SimpleProfessionalDTO professionalDTO) {
        SimpleProfessionalDTO newProfessional = this.professionalService.saveForFirstTime(professionalDTO);
        return new ResponseEntity<>(newProfessional,HttpStatus.CREATED);
    }

    @CrossOrigin
    @PutMapping(value = "/professionals/{professionalID}/zones", produces = "application/json", consumes = "application/json")
    public ResponseEntity<List<ZoneDTO>> modifyZoneToProfessional(@PathVariable Long professionalID, @RequestBody List<ZoneDTO> zoneDTOS) {
        List<ZoneDTO> zonesOfProfessional = this.professionalService.modifyZoneToProfessional(professionalID, zoneDTOS);
        return new ResponseEntity<>(zonesOfProfessional, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/professionals/{professionalID}/zones", produces = "application/json")
    public ResponseEntity<List<ZoneDTO>> getZonesFromProfessional(@PathVariable Long professionalID) {
        List<ZoneDTO> zones = this.professionalService.getAllZonesFromProfessional(professionalID);

        return new ResponseEntity<List<ZoneDTO>>(zones, HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping (value = "/professionals/{professionalID}/trades", produces = "application/json", consumes = "application/json")
    public ResponseEntity<List<TradeDTO>> modifyTradeToProfessional(@PathVariable Long professionalID, @RequestBody List<TradeDTO> tradeDTOS) {
        List<TradeDTO> tradesOfProfessional = this.professionalService.modifyTradesToProfessional(professionalID, tradeDTOS);

        return new ResponseEntity<>(tradesOfProfessional, HttpStatus.OK);
    }

}
