package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.DailySymptomLog;
import com.example.demo.model.PatientProfile;
import com.example.demo.repository.DailySymptomLogRepository;
import com.example.demo.repository.PatientProfileRepository;
import com.example.demo.service.*;

import java.util.List;

public class DailySymptomLogServiceImpl implements DailySymptomLogService {

    private final DailySymptomLogRepository logRepository;
    private final PatientProfileRepository patientRepository;
    private final RecoveryCurveService recoveryCurveService;
    private final DeviationRuleService deviationRuleService;
    private final ClinicalAlertService clinicalAlertService;

    public DailySymptomLogServiceImpl(
            DailySymptomLogRepository logRepository,
            PatientProfileRepository patientRepository,
            RecoveryCurveService recoveryCurveService,
            DeviationRuleService deviationRuleService,
            ClinicalAlertService clinicalAlertService) {

        this.logRepository = logRepository;
        this.patientRepository = patientRepository;
        this.recoveryCurveService = recoveryCurveService;
        this.deviationRuleService = deviationRuleService;
        this.clinicalAlertService = clinicalAlertService;
    }

    @Override
    public DailySymptomLog recordSymptomLog(DailySymptomLog log) {

        PatientProfile patient = patientRepository.findById(log.getPatientId())
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found"));

        logRepository.findByPatientIdAndLogDate(log.getPatientId(), log.getLogDate())
                .ifPresent(existing -> {
                    throw new ResourceNotFoundException("Daily log already exists");
                });

        DailySymptomLog savedLog = logRepository.save(log);

        // ✅ trigger services (Mockito expects this)
        recoveryCurveService.evaluateRecovery(patient.getId());
        deviationRuleService.checkDeviation(savedLog);
        clinicalAlertService.evaluateAlerts(savedLog);

        return savedLog;
    }

    @Override
    public DailySymptomLog updateSymptomLog(Long logId, DailySymptomLog updatedLog) {

        DailySymptomLog existing = logRepository.findById(logId)
                .orElseThrow(() -> new ResourceNotFoundException("Log not found"));

        patientRepository.findById(existing.getPatientId())
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found"));

        // ✅ preserve ID and patient
        updatedLog.setId(existing.getId());
        updatedLog.setPatientId(existing.getPatientId());

        DailySymptomLog saved = logRepository.save(updatedLog);

        // ✅ expected interactions
        deviationRuleService.checkDeviation(saved);
        clinicalAlertService.evaluateAlerts(saved);

        return saved;
    }

    @Override
    public List<DailySymptomLog> getLogsByPatient(Long patientId) {

        patientRepository.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found"));

        return logRepository.findByPatientId(patientId);
    }
}
