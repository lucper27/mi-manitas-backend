package com.lucasoft.mimanitas.application.mapper;

import com.lucasoft.mimanitas.application.dto.ZoneDTO;
import com.lucasoft.mimanitas.domain.entity.Zone;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ProfessionalMapper.class})
public interface ZoneMapper extends EntityMapper<ZoneDTO, Zone>{

}
