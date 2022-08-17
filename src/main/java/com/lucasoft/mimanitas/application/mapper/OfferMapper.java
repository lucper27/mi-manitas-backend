package com.lucasoft.mimanitas.application.mapper;

import com.lucasoft.mimanitas.application.dto.OfferDTO;
import com.lucasoft.mimanitas.domain.entity.Offer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OfferMapper extends EntityMapper<OfferDTO, Offer>{
}
