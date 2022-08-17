package com.lucasoft.mimanitas.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;


@Entity
@Table(name = "professionals")
public class Professional {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "professionalSequence")
    private Long id;
    @Column(nullable = false, length = 100)
    @Size(min = 3, max = 100)
    private String userName;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "rel_professionals_zones",
               joinColumns = @JoinColumn(name = "professional_id"),
               inverseJoinColumns = @JoinColumn(name = "zone_id"))
    private Set<Zone> zones;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "rel_professionals_trades",
            joinColumns = @JoinColumn(name = "professional_id"),
            inverseJoinColumns = @JoinColumn(name = "trade_id"))
    private Set<Trade> trades;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "rel_everyone_offers",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "offer_id"))
    private Set<Offer> offers;

    /*
            // TODO: completar relaciones entre entidades


            private Set<OfferApplication> offerApplications;*/
    @Lob
    @Column(nullable = true)
    private byte[] profilePic;

    //private byte[][] portfolioPics;
    @Column(nullable = true, length = 1000)
    @Size(min = 1, max = 1000)
    private String description;
    @Column(nullable = false, length = 15)
    @Size(min = 1, max = 15)
    private String phone;

    @Column(nullable = false, length = 100)
    @Size(min = 1, max = 100)
    private String email;

    public Professional() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Set<Zone> getZones() {
        return zones;
    }

    public void setZones(Set<Zone> zones) {
        this.zones = zones;
    }

    public Set<Trade> getTrades() {
        return trades;
    }

    public void setTrades(Set<Trade> trades) {
        this.trades = trades;
    }

    /*
    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    public List<OfferApplication> getOfferApplications() {
        return offerApplications;
    }

    public void setOfferApplications(List<OfferApplication> offerApplications) {
        this.offerApplications = offerApplications;
    }*/

    public byte[] getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(byte[] profilePic) {
        this.profilePic = profilePic;
    }

   /* public byte[][] getPortfolioPics() {
        return portfolioPics;
    }

    public void setPortfolioPics(byte[][] portfolioPics) {
        this.portfolioPics = portfolioPics;
    }*/

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Offer> getOffers() {
        return offers;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }
}
