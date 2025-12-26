package com.example.demo.controller;

import com.example.demo.model.PatientProfile;
import com.example.demo.service.PatientProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patients")
public class PatientProfileController {

    private final PatientProfileService service;

    public PatientProfileController(PatientProfileService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PatientProfile> createPatient(
            @RequestBody PatientProfile profile) {

        profile.setId(null); // NEVER trust client id
        return ResponseEntity.ok(service.createPatient(profile));
    }

    @GetMapping
    public List<PatientProfile> getAll() {
        return service.getAllPatients();
    }

    @GetMapping("/{id}")
    public PatientProfile getById(@PathVariable Long id) {
        return service.getPatientById(id);
    }

    @PutMapping("/{id}/status")
    public PatientProfile updateStatus(
            @PathVariable Long id,
            @RequestParam boolean active) {

        return service.updatePatientStatus(id, active);
    }

    @GetMapping("/lookup/{patientId}")
    public Optional<PatientProfile> lookup(
            @PathVariable String patientId) {

        return service.findByPatientId(patientId);
    }
}
