package com.esprit.microservices.pidevmicroservice.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Participant  implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long idParticipant;

        @Column(name = "userName")

        private String userName;
        @Column(name = "email")

        private String email;
        @Column(name = "file_name")
        private String filename;

        @Column(name = "content_type")
        private String contentType;

        @Enumerated(EnumType.STRING)
        TypeTask typeTask ;

        @Enumerated(EnumType.STRING)
        private Status status;


        @Lob
        @Column(name = "file", columnDefinition="BLOB")
        private byte[] file;

        public Long getIdParticipant() {
                return idParticipant;
        }

        public void setIdParticipant(Long idParticipant) {
                this.idParticipant = idParticipant;
        }

        public Status getStatus() {
                return status;
        }

        public void setStatus(Status status) {
                this.status = status;
        }

        public Participant(String userName, String email, String filename, String contentType, TypeTask typeTask) {
                this.userName = userName;
                this.email = email;
                this.filename = filename;
                this.contentType = contentType;
                this.typeTask = typeTask;
                this.status = status;
                this.file = file;
        }
}


