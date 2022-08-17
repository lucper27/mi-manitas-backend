package com.lucasoft.mimanitas.application.service.implementation;

import com.lucasoft.mimanitas.application.dto.TradeDTO;
import com.lucasoft.mimanitas.application.mapper.TradeMapper;
import com.lucasoft.mimanitas.application.service.TradeService;
import com.lucasoft.mimanitas.domain.entity.Trade;
import com.lucasoft.mimanitas.domain.persistence.TradePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeServiceImpl implements TradeService {

    private final TradePersistence tradePersistence;

    private final TradeMapper tradeMapper;

    @Autowired
    public TradeServiceImpl(TradePersistence tradePersistence, TradeMapper tradeMapper) {
        this.tradePersistence = tradePersistence;
        this.tradeMapper = tradeMapper;
    }

    @Override
    public TradeDTO save(TradeDTO tradeDto) {
        Trade trade = this.tradePersistence.save(this.tradeMapper.toEntity(tradeDto));
        return this.tradeMapper.toDto(trade);
    }

    @Override
    public List<TradeDTO> getAllTrades() {
        List<Trade> trades = this.tradePersistence.getAllTrades();
        return this.tradeMapper.toDto(trades);
    }

    @Override
    public void deleteTrade(Long tradeID) {
        this.tradePersistence.deleteTrade(tradeID);
    }
}
