package com.lucasoft.mimanitas.application.mapper;

import com.lucasoft.mimanitas.application.dto.ProfessionalDTO;
import com.lucasoft.mimanitas.application.dto.SimpleProfessionalDTO;
import com.lucasoft.mimanitas.domain.entity.Professional;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfessionalMapper extends EntityMapper<ProfessionalDTO, Professional>{

    SimpleProfessionalDTO toSimpleDto(Professional professional);

    ProfessionalDTO toDto(Professional professional);

    Professional toEntity(SimpleProfessionalDTO simpleProfessionalDTO);

    Professional toEntity(ProfessionalDTO professionalDTO);
}
