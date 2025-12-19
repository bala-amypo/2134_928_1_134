// File: PatientProfileController.java
package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.PatientProfile;
import com.example.demo.service.PatientProfileService;

@RestController
@RequestMapping("/api/patients")
public class PatientProfileController {

    private final PatientProfileService service;

    public PatientProfileController(PatientProfileService service) {
        this.service = service;
    }

    // CREATE PATIENT
    @PostMapping
    public PatientProfile createPatient(@RequestBody PatientProfile patient) {
        return service.createPatient(patient);
    }

    // GET ALL PATIENTS
    @GetMapping
    public List<PatientProfile> getAllPatients() {
        return service.getAllPatients();
    }

    // GET PATIENT BY ID
    @GetMapping("/{id}")
    public PatientProfile getPatientById(@PathVariable Long id) {
        return service.getPatientById(id);
    }

    // GET PATIENT BY PATIENT ID
    @GetMapping("/lookup/{patientId}")
    public PatientProfile getByPatientId(@PathVariable String patientId) {
        return service.findByPatientId(patientId);
    }

    // UPDATE PATIENT STATUS
    @PutMapping("/{id}/status")
    public PatientProfile updateStatus(@PathVariable Long id,
                                       @RequestParam Boolean active) {
        return service.updatePatientStatus(id, active);
    }
}
