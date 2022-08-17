package com.lucasoft.mimanitas.application.mapper;

import com.lucasoft.mimanitas.application.dto.TradeDTO;
import com.lucasoft.mimanitas.domain.entity.Trade;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TradeMapper extends EntityMapper<TradeDTO, Trade>{
}
