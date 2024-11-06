package tn.esprit.microservice.packmicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.microservice.packmicroservice.entity.Pack;
import tn.esprit.microservice.packmicroservice.serviceImpl.PackService;

import java.util.List;
@RestController
@RequestMapping("/api/packs")
public class PackController {
    @Autowired
    private PackService packService;

    @GetMapping
    public List<Pack> getAllPacks() {
        return packService.getAllPacks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pack> getPackById(@PathVariable Long id) {
        return packService.getPackById(id)
                .map(pack -> ResponseEntity.ok().body(pack))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pack> createPack(@RequestBody Pack pack) {
        Pack createdPack = packService.createPack(pack);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPack);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pack> updatePack(@PathVariable Long id, @RequestBody Pack packDetails) {
        Pack updatedPack = packService.updatePack(id, packDetails);
        return ResponseEntity.ok(updatedPack);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePack(@PathVariable Long id) {
        packService.deletePack(id);
        return ResponseEntity.noContent().build();
    }
}
