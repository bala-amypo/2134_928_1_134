// File: ClinicalAlertServiceImpl.java
package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ClinicalAlert;
import com.example.demo.entity.PatientProfile;
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

    public List<ClinicalAlert> getAlertsForPatient(Long patientId) {
        PatientProfile patient = patientRepo.findById(patientId).orElseThrow();
        return alertRepo.findByPatient(patient);
    }

    public List<ClinicalAlert> getUnresolvedAlerts() {
        return alertRepo.findByResolvedFalse();
    }

    public ClinicalAlert resolveAlert(Long id) {
        ClinicalAlert alert = alertRepo.findById(id).orElseThrow();
        alert.setResolved(true);
        return alertRepo.save(alert);
    }
}