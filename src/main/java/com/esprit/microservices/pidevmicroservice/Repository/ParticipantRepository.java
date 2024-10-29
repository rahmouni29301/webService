package com.esprit.microservices.pidevmicroservice.Repository;

import com.esprit.microservices.pidevmicroservice.Entity.Participant;
import com.esprit.microservices.pidevmicroservice.Entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant , Long> {
    long countByStatus(Status status);

}

