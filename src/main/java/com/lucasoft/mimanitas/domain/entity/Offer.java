package com.lucasoft.mimanitas.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "offers")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "offerSequence")
    private Long id;

    @Column(nullable = false, length = 100)
    @Size(min = 3, max = 20)
    private String title;

    @Lob
    private byte[] coverPic;



    //private byte[][] extraPics; todo: hacer relacion de las extra pics

    @Column(nullable = false, length = 1000)
    @Size(min = 1, max = 1000)
    private String description;

    private Float budget;

    // private candidatesID todo: ver como hacer esta relacion

    // private List<Zone> zones; todo: hacer relacion

    // todo: offerApplication es una tabla intermedia, falta hacer


    public Offer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public byte[] getCoverPic() {
        return coverPic;
    }

    public void setCoverPic(byte[] coverPic) {
        this.coverPic = coverPic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getBudget() {
        return budget;
    }

    public void setBudget(Float budget) {
        this.budget = budget;
    }
}
