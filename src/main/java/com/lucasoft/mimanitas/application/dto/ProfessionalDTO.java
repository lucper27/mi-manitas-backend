package com.lucasoft.mimanitas.application.dto;


import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class ProfessionalDTO implements Serializable {

    private Long id;

    private String userName;

    private byte[] profilePic;

    private String description;

    private String phone;

    private String email;

    private List<ZoneDTO> zones;

    private List<TradeDTO> trades;

    private List<OfferDTO> offers;

    //todo: falta agregar todas las listas de extra pics
    //private byte[][] portfolioPics;

    public ProfessionalDTO() {
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

    public byte[] getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(byte[] profilePic) {
        this.profilePic = profilePic;
    }

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

    public List<ZoneDTO> getZones() {
        return zones;
    }

    public void setZones(List<ZoneDTO> zones) {
        this.zones = zones;
    }

    public List<TradeDTO> getTrades() {
        return trades;
    }

    public void setTrades(List<TradeDTO> trades) {
        this.trades = trades;
    }

    public List<OfferDTO> getOffers() {
        return offers;
    }

    public void setOffers(List<OfferDTO> offers) {
        this.offers = offers;
    }

    @Override
    public String toString() {
        return "ProfessionalDTO{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", profilePic=" + Arrays.toString(profilePic) +
                ", description='" + description + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", zones=" + zones +
                '}';
    }
}
