package com.lucasoft.mimanitas.infraestructure.persistence;

import com.lucasoft.mimanitas.domain.entity.Professional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfessionalRepository extends JpaRepository<Professional, Long> {

    Professional getProfessionalById(Long id);

    List<Professional> findAll();

    Professional save(Professional professional);
}
