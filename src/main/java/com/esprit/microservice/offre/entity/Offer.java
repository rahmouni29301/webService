package com.esprit.microservice.offre.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Offer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idOffer;
    String name;
    String description;
    LocalDate dateOffer;
    String domain;

    @Enumerated(EnumType.STRING)
    TypeOffer typeOffer;


    // Constructeur avec tous les paramètres
    public Offer(String name, String description, LocalDate dateOffer, String domain, TypeOffer typeOffer) {
        this.name = name;
        this.description = description;
        this.dateOffer = dateOffer;
        this.domain = domain;
        this.typeOffer = typeOffer;
    }

    // Constructeur sans paramètres (obligatoire pour JPA)
    public Offer() {}

    // Getters and Setters
    public Long getIdOffer() {
        return idOffer;
    }

    public void setIdOffer(Long idOffer) {
        this.idOffer = idOffer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateOffer() {
        return dateOffer;
    }

    public void setDateOffer(LocalDate dateOffer) {
        this.dateOffer = dateOffer;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public TypeOffer getTypeOffer() {
        return typeOffer;
    }

    public void setTypeOffer(TypeOffer typeOffer) {
        this.typeOffer = typeOffer;
    }
}
