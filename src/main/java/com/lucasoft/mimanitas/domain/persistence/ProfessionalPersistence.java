package com.lucasoft.mimanitas.domain.persistence;

import com.lucasoft.mimanitas.domain.entity.Professional;

import java.util.List;

public interface ProfessionalPersistence {

    List<Professional> getAllProfessionals();

    Professional save(Professional professional);

    Professional getProfessionalById(Long id);
}
