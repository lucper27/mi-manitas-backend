package com.lucasoft.mimanitas.application.service.implementation;

import com.lucasoft.mimanitas.application.dto.ProfessionalDTO;
import com.lucasoft.mimanitas.application.dto.SimpleProfessionalDTO;
import com.lucasoft.mimanitas.application.dto.TradeDTO;
import com.lucasoft.mimanitas.application.dto.ZoneDTO;
import com.lucasoft.mimanitas.application.mapper.ProfessionalMapper;
import com.lucasoft.mimanitas.application.service.ProfessionalService;
import com.lucasoft.mimanitas.domain.entity.Professional;
import com.lucasoft.mimanitas.domain.persistence.ProfessionalPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProfessionalServiceImpl implements ProfessionalService {

    private final ProfessionalPersistence professionalPersistence;

    private final ProfessionalMapper professionalMapper;


    @Autowired
    public ProfessionalServiceImpl(ProfessionalPersistence professionalPersistence, ProfessionalMapper professionalMapper) {
        this.professionalPersistence = professionalPersistence;
        this.professionalMapper = professionalMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProfessionalDTO> getAllProfessionals() {
        List<Professional> professionals = this.professionalPersistence.getAllProfessionals();
        return this.professionalMapper.toDto(professionals);
    }

    @Override
    @Transactional
    public SimpleProfessionalDTO saveForFirstTime(SimpleProfessionalDTO simpleProfessionalDTO) {
     Professional professional = this.professionalPersistence.save(this.professionalMapper.toEntity(simpleProfessionalDTO));
        return this.professionalMapper.toSimpleDto(professional);
    }

    @Override
    @Transactional
    public ProfessionalDTO save(ProfessionalDTO professionalDTO) {
        Professional professional = this.professionalPersistence.save(this.professionalMapper.toEntity(professionalDTO));
        return this.professionalMapper.toDto(professional);
    }

    @Override
    @Transactional(readOnly = true)
    public ProfessionalDTO getProfessionalById(Long id) {
        Professional professional = this.professionalPersistence.getProfessionalById(id);
        return this.professionalMapper.toDto(professional);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ZoneDTO> getAllZonesFromProfessional(Long professionalID) {
        Professional professional = this.professionalPersistence.getProfessionalById(professionalID);
        ProfessionalDTO professionalDTO = this.professionalMapper.toDto(professional);

        return professionalDTO.getZones();
    }

    @Override
    @Transactional
    public List<ZoneDTO> modifyZoneToProfessional(Long professionalID, List<ZoneDTO> zoneDTOS) {
        Professional professional = this.professionalPersistence.getProfessionalById(professionalID);
        ProfessionalDTO professionalDTO = this.professionalMapper.toDto(professional);

        modifyZonesToProfessionalDTO(zoneDTOS, professionalDTO);

        professional = this.professionalPersistence.save(this.professionalMapper.toEntity(professionalDTO));
        professionalDTO = this.professionalMapper.toDto(professional);

        return professionalDTO.getZones();
    }
    private void modifyZonesToProfessionalDTO(List<ZoneDTO> zoneDTOS, ProfessionalDTO professionalDTO) {
        professionalDTO.getZones().clear();
        for (ZoneDTO eachZone: zoneDTOS) {
            professionalDTO.getZones().add(eachZone);
        }
    }
    @Override
    @Transactional
    public List<TradeDTO> modifyTradesToProfessional(Long professionalID, List<TradeDTO> tradeDTOS) {
        Professional professional = this.professionalPersistence.getProfessionalById(professionalID);
        ProfessionalDTO professionalDTO = this.professionalMapper.toDto(professional);

        modifyTradesToProfessionalDTO(tradeDTOS, professionalDTO);

        professional = this.professionalPersistence.save(this.professionalMapper.toEntity(professionalDTO));
        professionalDTO = this.professionalMapper.toDto(professional);

        return professionalDTO.getTrades();
    }
    public void modifyTradesToProfessionalDTO(List<TradeDTO> tradeDTOS, ProfessionalDTO professionalDTO) {
        professionalDTO.getTrades().clear();
        for (TradeDTO eachTrade: tradeDTOS) {
            professionalDTO.getTrades().add(eachTrade);
        }
    }

}
