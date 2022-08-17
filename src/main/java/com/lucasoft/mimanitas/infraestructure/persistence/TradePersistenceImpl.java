package com.lucasoft.mimanitas.infraestructure.persistence;

import com.lucasoft.mimanitas.domain.entity.Trade;
import com.lucasoft.mimanitas.domain.persistence.TradePersistence;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TradePersistenceImpl implements TradePersistence {

    private final TradeRepository tradeRepository;

    public TradePersistenceImpl(TradeRepository tradeRepository) {
        this.tradeRepository = tradeRepository;
    }

    @Override
    public List<Trade> getAllTrades() {
        List<Trade> trades = this.tradeRepository.findAll();
        return trades;
    }

    @Override
    public Trade save(Trade trade) {
        return this.tradeRepository.save(trade);
    }

    @Override
    public void deleteTrade(Long tradeID) {
        this.tradeRepository.deleteById(tradeID);
    }
}
