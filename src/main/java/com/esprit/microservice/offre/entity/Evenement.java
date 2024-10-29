package com.esprit.microservice.offre.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.time.LocalDate;
@Entity
public class Evenement implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long idEvenement;
        String nom;
        LocalDate dateEvenement;
        String description;

        public Evenement(String nom, LocalDate dateEvenement, String description) {
                this.nom = nom;
                this.dateEvenement = dateEvenement;
                this.description = description;
        }

        public Evenement() {

        }

        @Override
        public String toString() {
                return "Evenement{" +
                        "idEvenement=" + idEvenement +
                        ", nom='" + nom + '\'' +
                        ", dateEvenement=" + dateEvenement +
                        ", description='" + description + '\'' +
                        '}';
        }



        public Long getIdEvenement() {
                return idEvenement;
        }

        public void setIdEvenement(Long idEvenement) {
                this.idEvenement = idEvenement;
        }

        public String getNom() {
                return nom;
        }

        public void setNom(String nom) {
                this.nom = nom;
        }

        public LocalDate getDateEvenement() {
                return dateEvenement;
        }

        public void setDateEvenement(LocalDate dateEvenement) {
                this.dateEvenement = dateEvenement;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }
}
