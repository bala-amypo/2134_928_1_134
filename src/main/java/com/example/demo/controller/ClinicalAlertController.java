// File: ClinicalAlertController.java
package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.ClinicalAlert;
import com.example.demo.service.ClinicalAlertService;

@RestController
@RequestMapping("/api/alerts")
public class ClinicalAlertController {

    private final ClinicalAlertService service;

    public ClinicalAlertController(ClinicalAlertService service) {
        this.service = service;
    }

    // GET ALERTS FOR PATIENT
    @GetMapping("/patient/{patientId}")
    public List<ClinicalAlert> getAlertsForPatient(@PathVariable Long patientId) {
        return service.getAlertsForPatient(patientId);
    }

    // GET UNRESOLVED ALERTS
    @GetMapping("/unresolved")
    public List<ClinicalAlert> getUnresolvedAlerts() {
        return service.getUnresolvedAlerts();
    }

    // RESOLVE ALERT
    @PutMapping("/{id}/resolve")
    public ClinicalAlert resolveAlert(@PathVariable Long id) {
        return service.resolveAlert(id);
    }
}
