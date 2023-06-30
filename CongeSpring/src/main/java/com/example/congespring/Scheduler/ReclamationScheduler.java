package com.example.congespring.Scheduler;

import com.example.congespring.Service.interfaces.ReclamationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ReclamationScheduler {

    private final ReclamationService reclamationService;

    @Autowired
    public ReclamationScheduler(ReclamationService reclamationService) {
        this.reclamationService = reclamationService;
    }

    @Scheduled(cron = "0 0 0 * * *") // Run at midnight every day
    public void deleteExpiredReclamations() {
        // Call the service method to delete expired reclamations
        reclamationService.deleteExpiredReclamations();
    }
}
