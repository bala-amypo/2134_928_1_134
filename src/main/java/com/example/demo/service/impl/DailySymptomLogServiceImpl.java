package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.*;

import java.util.List;

public class DailySymptomLogServiceImpl implements DailySymptomLogService {

    private final DailySymptomLogRepository logRepo;
    private final PatientProfileRepository patientRepo;

    public DailySymptomLogServiceImpl(
            DailySymptomLogRepository l,
            PatientProfileRepository p,
            RecoveryCurveService r,
            DeviationRuleService d,
            ClinicalAlertService c) {

        this.logRepo = l;
        this.patientRepo = p;
    }

    public DailySymptomLog recordSymptomLog(DailySymptomLog log) {

        patientRepo.findById(log.getPatientId())
                .orElseThrow(() -> new ResourceNotFoundException("Patient missing"));

        if (logRepo.findByPatientIdAndLogDate(log.getPatientId(), log.getLogDate()).isPresent()) {
            throw new IllegalArgumentException("Duplicate log");
        }

        return logRepo.save(log);
    }

    public DailySymptomLog updateSymptomLog(Long id, DailySymptomLog updated) {

        DailySymptomLog existing = logRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Log not found"));

        patientRepo.findById(updated.getPatientId())
                .orElseThrow(() -> new ResourceNotFoundException("Patient missing"));

        existing.setPainLevel(updated.getPainLevel());
        existing.setMobilityLevel(updated.getMobilityLevel());
        existing.setFatigueLevel(updated.getFatigueLevel());
        existing.setPatientId(updated.getPatientId());

        return logRepo.save(existing);
    }

    public List<DailySymptomLog> getLogsByPatient(Long pid) {
        patientRepo.findById(pid)
                .orElseThrow(() -> new ResourceNotFoundException("Patient missing"));
        return logRepo.findByPatientId(pid);
    }
}
