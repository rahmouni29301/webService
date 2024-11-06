package tn.esprit.microservice.packmicroservice.serviceImpl;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.microservice.packmicroservice.entity.Pack;
import tn.esprit.microservice.packmicroservice.repository.PackRepository;

import java.util.List;
import java.util.Optional;
@Service
public class PackService {
    @Autowired
    private PackRepository packRepository;

    public List<Pack> getAllPacks() {
        return packRepository.findAll();
    }

    public Optional<Pack> getPackById(Long id) {
        return packRepository.findById(id);
    }

    public Pack createPack(Pack pack) {
        return packRepository.save(pack);
    }

    public Pack updatePack(Long id, Pack packDetails) {
        Pack pack = packRepository.findById(id).orElseThrow(() -> new RuntimeException("Pack not found"));
        pack.setDescription(packDetails.getDescription());
        pack.setPrice(packDetails.getPrice());
        pack.setSalle(packDetails.getSalle());
        pack.setNbMax(packDetails.getNbMax());
        pack.setNbBooths(packDetails.getNbBooths());
        return packRepository.save(pack);
    }

    public void deletePack(Long id) {
        packRepository.deleteById(id);
    }
}

