package com.lucasoft.mimanitas.infraestructure.rest;

import com.lucasoft.mimanitas.application.dto.ZoneDTO;
import com.lucasoft.mimanitas.application.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ZoneRestController {

    private final ZoneService zoneService;

    @Autowired
    public ZoneRestController(ZoneService zoneService) {
        this.zoneService = zoneService;
    }

    @CrossOrigin
    @GetMapping(value = "/zones", produces = "application/json")
    public ResponseEntity<List<ZoneDTO>> getAllZones() {
        List<ZoneDTO> zoneDTOS = this.zoneService.getAllZones();

        return new ResponseEntity<List<ZoneDTO>>(zoneDTOS, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/zones",  produces = "application/json", consumes = "application/json")
    public ResponseEntity<ZoneDTO> addNewZone(@RequestBody ZoneDTO zoneDTO) {
        ZoneDTO newZoneDTO = this.zoneService.save(zoneDTO);

        return new ResponseEntity<ZoneDTO>(newZoneDTO, HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping(value = "/zones/{zoneID}")
    public ResponseEntity<?> deleteZoneByID(@PathVariable Long zoneID) {
        this.zoneService.deleteZone(zoneID);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
