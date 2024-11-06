package com.esprit.microservice.offre.entity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CallForTender implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idCOT;
    String description;
    long quantity;
    String name;
    String pdfFileName;


}