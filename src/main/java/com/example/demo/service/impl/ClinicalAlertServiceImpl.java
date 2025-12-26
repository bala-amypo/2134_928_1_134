package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.ClinicalAlert;
import com.example.demo.entity.PatientProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ClinicalAlertRepository;
import com.example.demo.repository.PatientProfileRepository;

@Service
public class ClinicalAlertServiceImpl implements ClinicalAlertService {

    private final ClinicalAlertRepository alertRepo;
    private final PatientProfileRepository patientRepo;

    public ClinicalAlertServiceImpl(ClinicalAlertRepository alertRepo,
                                    PatientProfileRepository patientRepo) {
        this.alertRepo = alertRepo;
        this.patientRepo = patientRepo;
    }

    @Override
    public List<ClinicalAlert> getAlertsForPatient(Long patientId) {
        PatientProfile patient = patientRepo.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Patient not found with id: " + patientId));

        return alertRepo.findByPatient(patient);
    }

    @Override
    public List<ClinicalAlert> getUnresolvedAlerts() {
        return alertRepo.findByResolvedFalse();
    }

    @Override
    public ClinicalAlert resolveAlert(Long id) {
        ClinicalAlert alert = alertRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Clinical alert not found with id: " + id));

        alert.setResolved(true);
        return alertRepo.save(alert);
    }
}
