package com.lucasoft.mimanitas.infraestructure.rest;

import com.lucasoft.mimanitas.application.dto.TradeDTO;
import com.lucasoft.mimanitas.application.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TradeRestController {

    private final TradeService tradeService;

    @Autowired
    public TradeRestController(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    @CrossOrigin
    @GetMapping(value = "/trades", produces = "application/json")
    public ResponseEntity<List<TradeDTO>> getAllTrades() {
        List<TradeDTO> tradeDTOS = this.tradeService.getAllTrades();

        return new ResponseEntity<List<TradeDTO>>(tradeDTOS, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/trades",  produces = "application/json", consumes = "application/json")
    public ResponseEntity<TradeDTO> addNewZone(@RequestBody TradeDTO tradeDTO) {
        TradeDTO newTradeDTO = this.tradeService.save(tradeDTO);

        return new ResponseEntity<TradeDTO>(newTradeDTO, HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping(value = "/trades/{tradeID}")
    public ResponseEntity<?> deleteTradeByID(@PathVariable Long tradeID) {
        this.tradeService.deleteTrade(tradeID);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
