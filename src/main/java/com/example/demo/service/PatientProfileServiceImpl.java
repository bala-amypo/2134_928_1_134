package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.PatientProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.PatientProfileRepository;

@Service
public class PatientProfileServiceImpl implements PatientProfileService {

    private final PatientProfileRepository repo;

    public PatientProfileServiceImpl(PatientProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public PatientProfile createPatient(PatientProfile patient) {
        return repo.save(patient);
    }

    @Override
    public PatientProfile getPatientById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Patient not found with id: " + id));
    }

    @Override
    public PatientProfile findByPatientId(String patientId) {
        return repo.findByPatientId(patientId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Patient not found with patientId: " + patientId));
    }

    @Override
    public List<PatientProfile> getAllPatients() {
        return repo.findAll();
    }

    @Override
    public PatientProfile updatePatientStatus(Long id, Boolean active) {
        PatientProfile patient = getPatientById(id);
        patient.setActive(active);
        return repo.save(patient);
    }
}
