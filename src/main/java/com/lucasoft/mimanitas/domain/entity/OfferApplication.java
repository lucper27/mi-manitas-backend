package com.lucasoft.mimanitas.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "offer_applications")
public class OfferApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "offerApplicationSequence")
    private Long id;


}
