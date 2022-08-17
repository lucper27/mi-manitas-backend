package com.lucasoft.mimanitas.domain.persistence;

import com.lucasoft.mimanitas.domain.entity.Zone;
import java.util.List;

public interface ZonePersistence {

    List<Zone> getAllZones();

    Zone save(Zone zone);

    void deleteZone(Long zoneID);
}
