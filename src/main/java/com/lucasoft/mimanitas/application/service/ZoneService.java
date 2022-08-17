package com.lucasoft.mimanitas.application.service;

import com.lucasoft.mimanitas.application.dto.ZoneDTO;

import java.util.List;

public interface ZoneService {

    ZoneDTO save(ZoneDTO zoneDTO);

    List<ZoneDTO> getAllZones();

    void deleteZone(Long zoneID);

}
