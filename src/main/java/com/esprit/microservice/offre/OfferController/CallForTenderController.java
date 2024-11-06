package com.esprit.microservice.offre.OfferController;


import com.esprit.microservice.offre.entity.CallForTender;
import com.esprit.microservice.offre.serviceImpl.CallForTenderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/callForTender")
public class CallForTenderController {

    @Autowired
    private CallForTenderServiceImpl callForTenderService;

    @PostMapping
    public CallForTender createCallForTender(@RequestBody CallForTender callForTender) {
        return callForTenderService.addCallForTender(callForTender);
    }

    @GetMapping
    public List<CallForTender> getAllCallForTenders() {
        return callForTenderService.getAllCallForTenders();
    }
    @PutMapping("/{id}")
    public CallForTender updateCallForTender(@PathVariable Long id, @RequestBody CallForTender callForTender) {
        return callForTenderService.updateCallForTender(id, callForTender);
    }

    @DeleteMapping("/{id}")
    public void deleteCallForTender(@PathVariable Long id) {
        callForTenderService.deleteCallForTender(id);
    }
}
