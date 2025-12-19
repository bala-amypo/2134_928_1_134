// File: PatientProfileServiceImpl.java
package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PatientProfile;
import com.example.demo.repository.PatientProfileRepository;

@Service
public class PatientProfileServiceImpl implements PatientProfileService {

    private final PatientProfileRepository repo;

    public PatientProfileServiceImpl(PatientProfileRepository repo) {
        this.repo = repo;
    }

    public PatientProfile createPatient(PatientProfile patient) {
        return repo.save(patient);
    }

    public PatientProfile getPatientById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public PatientProfile findByPatientId(String patientId) {
        return repo.findByPatientId(patientId).orElseThrow();
    }

    public List<PatientProfile> getAllPatients() {
        return repo.findAll();
    }

    public PatientProfile updatePatientStatus(Long id, Boolean active) {
        PatientProfile p = getPatientById(id);
        p.setActive(active);
        return repo.save(p);
    }
}
