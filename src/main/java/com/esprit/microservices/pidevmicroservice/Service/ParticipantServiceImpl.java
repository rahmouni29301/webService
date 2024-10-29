package com.esprit.microservices.pidevmicroservice.Service;

import com.esprit.microservices.pidevmicroservice.Entity.Participant;
import com.esprit.microservices.pidevmicroservice.Entity.Status;
import com.esprit.microservices.pidevmicroservice.Repository.ParticipantRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor

public class ParticipantServiceImpl {
    private final ParticipantRepository participantRepository;

    public Participant addParticipantRequest(Participant participantRequest) {
        return participantRepository.save(participantRequest);
    }

    public Optional<Participant> getParticipantRequestById(Long idParticipant) {
        return participantRepository.findById(idParticipant);
    }

    public List<Participant> getAllParticipantRequests() {
        return participantRepository.findAll();
    }

    public Participant updateStatus(Long idParticipant, Status status) {
        Optional<Participant> optionalRequest = participantRepository.findById(idParticipant);
        if (optionalRequest.isPresent()) {
            Participant participantRequest = optionalRequest.get();
            participantRequest.setStatus(status);
            return participantRepository.save(participantRequest);
        } else {
            throw new IllegalArgumentException("Demande de participation non trouvée avec l'ID : " + idParticipant);
        }
    }

    public void deleteParticipantRequest(Long idParticipant) {
        participantRepository.deleteById(idParticipant);
    }


    public Participant addOrganiserToTask(Participant participantRequest) {
        return participantRepository.save(participantRequest);
    }


    public Participant updateParticipantStatus(Long idParticipant, Status status) {
        Optional<Participant> optionalParticipant = participantRepository.findById(idParticipant);

        if (optionalParticipant.isPresent()) {
            Participant participant = optionalParticipant.get();
            participant.setStatus(status); // Utilisez cette méthode si elle accepte Status ou une conversion en String
            return participantRepository.save(participant);
        } else {
            throw new EntityNotFoundException("Participant non trouvé avec l'ID : " + idParticipant);
        }
    }

    public Participant updateParticipant(Long idParticipant, Participant newParticipant) {
        if (participantRepository.findById(idParticipant).isPresent()) {
            Participant existingParticipant = participantRepository.findById(idParticipant).get();
            existingParticipant.setEmail(newParticipant.getEmail());
            existingParticipant.setUserName(newParticipant.getUserName());
            existingParticipant.setContentType(newParticipant.getContentType());
            return participantRepository.save(existingParticipant);
        } else
            return null;
    }
    public String deleteParticipant(Long idParticipant) {
        if (participantRepository.findById(idParticipant).isPresent()) {
            participantRepository.deleteById(idParticipant);
            return "candidat supprimé";
        } else
            return "candidat non supprimé";
    }
    public Participant addParticipant(Participant participant) {
        return participantRepository.save(participant);
    }

    public List<Participant> retriveAllParticipation() {
        return participantRepository.findAll();
    }

}
