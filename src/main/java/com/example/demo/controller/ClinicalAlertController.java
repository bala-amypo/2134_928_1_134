package com.example.demo.controller;

import com.example.demo.model.ClinicalAlertRecord;
import com.example.demo.service.ClinicalAlertService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/alerts")
public class ClinicalAlertController {

    private final ClinicalAlertService clinicalAlertService;

    public ClinicalAlertController(
            ClinicalAlertService clinicalAlertService) {
        this.clinicalAlertService = clinicalAlertService;
    }

    @PostMapping
    public ResponseEntity<ClinicalAlertRecord> create(
            @RequestBody ClinicalAlertRecord alert) {
        return ResponseEntity.ok(
                clinicalAlertService.createAlert(alert));
    }

    @PutMapping("/{id}/resolve")
    public ResponseEntity<ClinicalAlertRecord> resolve(
            @PathVariable Long id) {
        return ResponseEntity.ok(
                clinicalAlertService.resolveAlert(id));
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<ClinicalAlertRecord>> getByPatient(
            @PathVariable Long patientId) {
        return ResponseEntity.ok(
                clinicalAlertService.getAlertsByPatient(patientId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ClinicalAlertRecord>> getById(
            @PathVariable Long id) {
        return ResponseEntity.ok(
                clinicalAlertService.getAlertById(id));
    }

    @GetMapping
    public ResponseEntity<List<ClinicalAlertRecord>> getAll() {
        return ResponseEntity.ok(
                clinicalAlertService.getAllAlerts());
    }
}
