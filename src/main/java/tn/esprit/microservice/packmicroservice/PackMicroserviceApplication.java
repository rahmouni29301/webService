package tn.esprit.microservice.packmicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import tn.esprit.microservice.packmicroservice.entity.Pack;
import tn.esprit.microservice.packmicroservice.repository.PackRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class PackMicroserviceApplication {



    @Autowired
    private PackRepository packRepository;

    public static void main(String[] args) {
        SpringApplication.run(PackMicroserviceApplication.class, args);
    }

    @Bean
    ApplicationRunner init() {
        return (args) -> {
            // Save default packs
            packRepository.save(new Pack(null, "Pack de Développement Web", 100L, "Salle A", 50, 10));
            packRepository.save(new Pack(null, "Pack de Marketing Digital", 200L, "Salle B", 30, 5));
            packRepository.save(new Pack(null, "Pack de Design UX/UI", 150L, "Salle C", 40, 8));
            packRepository.save(new Pack(null, "Pack Séminaire sur l'Innovation", 250L, "Salle D", 20, 3));

            // Display all packs to verify
            packRepository.findAll().forEach(System.out::println);
        };
    }

}






