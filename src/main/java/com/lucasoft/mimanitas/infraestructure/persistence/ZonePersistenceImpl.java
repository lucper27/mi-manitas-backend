package com.lucasoft.mimanitas.infraestructure.persistence;

import com.lucasoft.mimanitas.domain.entity.Zone;
import com.lucasoft.mimanitas.domain.persistence.ZonePersistence;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ZonePersistenceImpl implements ZonePersistence {

    private final ZoneRepository zoneRepository;

    public ZonePersistenceImpl(ZoneRepository zoneRepository) {
        this.zoneRepository = zoneRepository;
    }

    @Override
    public List<Zone> getAllZones() {
        return this.zoneRepository.findAll();
    }

    @Override
    public Zone save(Zone zone) {
        return this.zoneRepository.save(zone);
    }

    @Override
    public void deleteZone(Long zoneID) {
        this.zoneRepository.deleteById(zoneID);
    }
}
