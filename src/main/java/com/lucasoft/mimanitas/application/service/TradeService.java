package com.lucasoft.mimanitas.application.service;

import com.lucasoft.mimanitas.application.dto.TradeDTO;

import java.util.List;

public interface TradeService {

    TradeDTO save(TradeDTO tradeDto);

    List<TradeDTO> getAllTrades();

    void deleteTrade(Long tradeID);
}
