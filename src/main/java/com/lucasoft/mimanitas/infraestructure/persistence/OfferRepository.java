package com.lucasoft.mimanitas.infraestructure.persistence;

import com.lucasoft.mimanitas.domain.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OfferRepository extends JpaRepository<Offer, Long> {

    Offer save(Offer offer);

    List<Offer> findAll();

    Offer getOfferById(Long id);


}
