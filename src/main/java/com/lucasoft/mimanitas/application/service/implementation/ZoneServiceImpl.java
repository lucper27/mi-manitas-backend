package com.lucasoft.mimanitas.application.service.implementation;

import com.lucasoft.mimanitas.application.dto.ZoneDTO;
import com.lucasoft.mimanitas.application.mapper.ZoneMapper;
import com.lucasoft.mimanitas.application.service.ZoneService;
import com.lucasoft.mimanitas.domain.entity.Zone;
import com.lucasoft.mimanitas.domain.persistence.ZonePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ZoneServiceImpl implements ZoneService {

    private final ZonePersistence zonePersistence;

    private final ZoneMapper zoneMapper;

    @Autowired
    public ZoneServiceImpl(ZonePersistence zonePersistence, ZoneMapper zoneMapper) {
        this.zonePersistence = zonePersistence;
        this.zoneMapper = zoneMapper;
    }

    @Override
    @Transactional
    public ZoneDTO save(ZoneDTO zoneDTO) {
        Zone zone = this.zonePersistence.save(this.zoneMapper.toEntity(zoneDTO));

        return this.zoneMapper.toDto(zone);
    }

    @Override
    public List<ZoneDTO> getAllZones() {
        return this.zoneMapper.toDto(this.zonePersistence.getAllZones());
    }

    @Override
    @Transactional
    public void deleteZone(Long zoneID) {
        this.zonePersistence.deleteZone(zoneID);
    }

}
