package com.lucasoft.mimanitas.domain.persistence;

import com.lucasoft.mimanitas.domain.entity.Trade;

import java.util.List;

public interface TradePersistence {

    List<Trade> getAllTrades();

    Trade save(Trade trade);

    void deleteTrade(Long tradeID);
}
