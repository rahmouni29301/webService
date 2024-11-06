package tn.esprit.microservice.packmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.microservice.packmicroservice.entity.Pack;
@Repository
public interface PackRepository extends JpaRepository<Pack,Long> {
}
