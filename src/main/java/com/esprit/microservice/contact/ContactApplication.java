package com.esprit.microservice.contact;

import com.esprit.microservice.contact.entity.Contact;
import com.esprit.microservice.contact.repository.ContactRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.List;

@EnableDiscoveryClient
@SpringBootApplication
public class ContactApplication {
    private final ContactRepository contactRepository;

    public ContactApplication(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }
    public static void main(String[] args) {
        SpringApplication.run(ContactApplication.class, args);
    }

    @Bean
    ApplicationRunner init() {
        return (args) -> {
            // Ajouter des contacts par défaut pour les tests
            List<Contact> defaultContacts = List.of(
                    new Contact(null, "John Doe", "john.doe@example.com", "123456789"),
                    new Contact(null, "Jane Smith", "jane.smith@example.com", "987654321"),
                    new Contact(null, "Alice Johnson", "alice.johnson@example.com", "555444333")
            );

            // Sauvegarder les contacts par défaut dans la base de données
            contactRepository.saveAll(defaultContacts);

            // Imprimer tous les contacts pour vérifier
            contactRepository.findAll().forEach(System.out::println);
        };
    }

}
