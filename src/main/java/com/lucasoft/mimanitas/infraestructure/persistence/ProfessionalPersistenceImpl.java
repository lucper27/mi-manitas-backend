package com.lucasoft.mimanitas.infraestructure.persistence;

import com.lucasoft.mimanitas.domain.entity.Professional;
import com.lucasoft.mimanitas.domain.persistence.ProfessionalPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProfessionalPersistenceImpl implements ProfessionalPersistence {

    private final ProfessionalRepository professionalRepository;

    @Autowired
    public ProfessionalPersistenceImpl(ProfessionalRepository professionalRepository) {
        this.professionalRepository = professionalRepository;
    }


    @Override
    public List<Professional> getAllProfessionals() {
        return this.professionalRepository.findAll();
    }

    @Override
    public Professional save(Professional professional) {
        return this.professionalRepository.save(professional);
    }

    @Override
    public Professional getProfessionalById(Long id) {
        return this.professionalRepository.getProfessionalById(id);
    }
}
