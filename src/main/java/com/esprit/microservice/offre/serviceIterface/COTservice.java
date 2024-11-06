package com.esprit.microservice.offre.serviceIterface;

import com.esprit.microservice.offre.entity.CallForTender;

import java.util.List;

public interface COTservice{
    CallForTender addCallForTender(CallForTender callForTender);
    List<CallForTender> getAllCallForTenders();
    CallForTender updateCallForTender(Long id, CallForTender callForTender);
    void deleteCallForTender(Long id);
}
