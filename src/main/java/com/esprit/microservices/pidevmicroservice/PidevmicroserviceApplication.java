package com.esprit.microservices.pidevmicroservice;

import com.esprit.microservices.pidevmicroservice.Entity.Participant;
import com.esprit.microservices.pidevmicroservice.Entity.TypeTask;
import com.esprit.microservices.pidevmicroservice.Repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;

@EnableEurekaServer
@SpringBootApplication
public class PidevmicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PidevmicroserviceApplication.class, args);
    }

    @Autowired
    private ParticipantRepository participantRepository;

    @Bean
    ApplicationRunner init() {
        return (args) -> {
            participantRepository.save(new Participant("Mariem", "ma@esprit.tn", "Ch", "etudiante", TypeTask.TIMEMANAGEMENT));
            participantRepository.save(new Participant("Sarra","sa@esprit.tn" , "ab", "etudiante", TypeTask.PARTICIPENTREGISTRATION));
            participantRepository.save(new Participant("Mohamed", "mo@esprit.tn", "Mh", "etudiante", TypeTask.TECHNICALSUPPORT));
            participantRepository.save(new Participant("Maroua", "maroua@esprit.tn", "Ch", "etudiante", TypeTask.TIMEMANAGEMENT));

            participantRepository.findAll().forEach(System.out::println);
        };
    }
}
