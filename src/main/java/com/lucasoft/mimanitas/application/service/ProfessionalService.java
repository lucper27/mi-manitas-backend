package com.lucasoft.mimanitas.application.service;

import com.lucasoft.mimanitas.application.dto.ProfessionalDTO;
import com.lucasoft.mimanitas.application.dto.SimpleProfessionalDTO;
import com.lucasoft.mimanitas.application.dto.TradeDTO;
import com.lucasoft.mimanitas.application.dto.ZoneDTO;

import java.util.List;

public interface ProfessionalService {

    List<ProfessionalDTO> getAllProfessionals();

    SimpleProfessionalDTO saveForFirstTime(SimpleProfessionalDTO professionalDTO);

    ProfessionalDTO save(ProfessionalDTO professionalDTO);

    ProfessionalDTO getProfessionalById(Long id);

    List<ZoneDTO> getAllZonesFromProfessional(Long professionalID);

    List<ZoneDTO> modifyZoneToProfessional(Long professionalID, List<ZoneDTO> zoneDTOS);

    List<TradeDTO> modifyTradesToProfessional(Long professionalID, List<TradeDTO> tradeDTOS);
}
