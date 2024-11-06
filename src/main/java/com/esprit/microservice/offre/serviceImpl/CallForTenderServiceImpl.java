package com.esprit.microservice.offre.serviceImpl;


import com.esprit.microservice.offre.entity.CallForTender;
import com.esprit.microservice.offre.repository.COTrepo;
import com.esprit.microservice.offre.serviceIterface.COTservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CallForTenderServiceImpl implements COTservice {

    @Autowired
    private COTrepo callForTenderRepository;
    @Override
    public CallForTender addCallForTender(CallForTender callForTender) {
        return callForTenderRepository.save(callForTender);
    }

    @Override
    public List<CallForTender> getAllCallForTenders() {
        return callForTenderRepository.findAll();

    }

    @Override
    public CallForTender updateCallForTender(Long id, CallForTender callForTender) {
        Optional<CallForTender> existingCOT = callForTenderRepository.findById(id);
        if (existingCOT.isPresent()) {
            CallForTender updatedCOT = existingCOT.get();
            updatedCOT.setDescription(callForTender.getDescription());
            updatedCOT.setQuantity(callForTender.getQuantity());
            updatedCOT.setName(callForTender.getName());
            updatedCOT.setPdfFileName(callForTender.getPdfFileName());
            return callForTenderRepository.save(updatedCOT);
        } else {
            throw new RuntimeException("CallForTender with ID " + id + " not found");
        }
    }

    @Override
    public void deleteCallForTender(Long id) {
        if (callForTenderRepository.existsById(id)) {
            callForTenderRepository.deleteById(id);
        } else {
            throw new RuntimeException("CallForTender with ID " + id + " not found");
        }
    }
}
