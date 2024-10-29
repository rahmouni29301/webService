package com.esprit.microservices.pidevmicroservice.Controller;

import com.esprit.microservices.pidevmicroservice.Entity.Participant;
import com.esprit.microservices.pidevmicroservice.Entity.Status;
import com.esprit.microservices.pidevmicroservice.Entity.TypeTask;
import com.esprit.microservices.pidevmicroservice.Repository.ParticipantRepository;
import com.esprit.microservices.pidevmicroservice.Service.ParticipantServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/participant")
public class ParticipantController {

       @Autowired
        private  ParticipantServiceImpl participantService;
       @Autowired
        private  ParticipantRepository participantRepository;


    @GetMapping("/getAllParticipantRequest")
    public List<Participant> retriveAllParticipantRequests() {
        return participantService.retriveAllParticipation();
    }
        @PostMapping("/addOrganiserToTask")
        public Participant addOrganiserToTask(@RequestBody Participant participantRequest) {
            return participantService.addOrganiserToTask(participantRequest);
        }

        @GetMapping("/files")
        public ResponseEntity<List<Participant>> getFiles() {
            return ResponseEntity.ok(participantRepository.findAll());
        }


        @PutMapping("/{idParticipantRequest}/status")
        public ResponseEntity<?> updateParticipantStatus(@PathVariable Long idParticipantRequest, @RequestBody String status) {
            try {
                participantService.updateParticipantStatus(idParticipantRequest, Status.valueOf(status));
                return ResponseEntity.ok().build();
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating participant status.");
            }
        }

        @GetMapping("/status/count")
        public Map<String, Long> getStatusCounts() {
            Map<String, Long> statusCounts = new HashMap<>();
            for (Status status : Status.values()) {
                statusCounts.put(status.toString().toLowerCase(), participantRepository.countByStatus(status));
            }
            return statusCounts;
        }



        private String buildEmailContent(String message) {
            return "<html><body style='font-family: Arial, sans-serif;'>"
                    + "<div style='background-color:#007bff; color:#fff; padding:10px; text-align:center;'>"
                    + "<h1>Welcome to Forum Planning</h1></div>"
                    + "<p>" + message + "</p>"
                    + "<div style='background-color:#f8f9fa; padding:10px; margin-top:20px;'>"
                    + "<h3 style='color:#ffc107;'>We'll review your qualifications. Stay tuned!</h3></div>"
                    + "<div style='background-color:#f8f9fa; padding:10px; margin-top:20px;'>"
                    + "<h3 style='color:#28a745;'>Check your status anytime. Thank you!</h3></div>"
                    + "</body></html>";
        }


    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Participant> createParticipant(@RequestBody Participant participant) {
        return new ResponseEntity<>(participantService.addParticipant(participant), HttpStatus.OK);
    }
    @PutMapping(value = "/{idParticipant}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Participant> updateParticipant(@PathVariable(value = "idParticipant") Long idParticipant,
                                                   @RequestBody Participant participant){
        return new ResponseEntity<>(participantService.updateParticipant(idParticipant, participant),
                HttpStatus.OK);
    }
    @DeleteMapping(value = "/{idParticipant}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteParticipant(@PathVariable(value = "idParticipant") Long idParticipant){
        return new ResponseEntity<>(participantService.deleteParticipant(idParticipant), HttpStatus.OK);
    }
}
