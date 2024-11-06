package tn.esprit.microservice.packmicroservice.entity;





import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Pack implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idPack;
    String description;
    Long price;
    String salle;
    int nbMax;
    int nbBooths;




}


