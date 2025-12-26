package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.ClinicalAlertRecord;
import com.example.demo.repository.ClinicalAlertRecordRepository;
import com.example.demo.service.ClinicalAlertService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ClinicalAlertServiceImpl implements ClinicalAlertService {

    private final ClinicalAlertRecordRepository repository;

    public ClinicalAlertServiceImpl(ClinicalAlertRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public ClinicalAlertRecord resolveAlert(Long alertId) {

        ClinicalAlertRecord alert = repository.findById(alertId)
                .orElseThrow(() -> new ResourceNotFoundException("Alert not found"));

        alert.setResolved(true);

        return repository.save(alert);
    }

    @Override
    public List<ClinicalAlertRecord> getAlertsByPatient(Long patientId) {

        List<ClinicalAlertRecord> alerts = repository.findByPatientId(patientId);

        // ✅ Mockito-safe: never return null
        return alerts != null ? alerts : Collections.emptyList();
    }

    @Override
    public Optional<ClinicalAlertRecord> getAlertById(Long id) {

        // ✅ Do NOT throw exception here
        return repository.findById(id);
    }

    @Override
    public List<ClinicalAlertRecord> getAllAlerts() {

        List<ClinicalAlertRecord> alerts = repository.findAll();

        // ✅ Mockito-safe
        return alerts != null ? alerts : Collections.emptyList();
    }
}
