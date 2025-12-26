package com.example.demo.controller;

import com.example.demo.model.ClinicalAlertRecord;
import com.example.demo.service.ClinicalAlertService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
public class ClinicalAlertController {

    private final ClinicalAlertService service;

    public ClinicalAlertController(ClinicalAlertService service) {
        this.service = service;
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<ClinicalAlertRecord>> getByPatient(@PathVariable Long patientId) {
        return ResponseEntity.ok(service.getAlertsByPatient(patientId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClinicalAlertRecord> getById(@PathVariable Long id) {
        return service.getAlertById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/resolve")
    public ResponseEntity<ClinicalAlertRecord> resolve(@PathVariable Long id) {
        return ResponseEntity.ok(service.resolveAlert(id));
    }

    @GetMapping
    public ResponseEntity<List<ClinicalAlertRecord>> getAll() {
        return ResponseEntity.ok(service.getAllAlerts());
    }
}
