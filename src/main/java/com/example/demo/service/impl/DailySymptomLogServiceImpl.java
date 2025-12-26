package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.DailySymptomLog;
import com.example.demo.repository.DailySymptomLogRepository;
import com.example.demo.repository.PatientProfileRepository;
import com.example.demo.service.DailySymptomLogService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DailySymptomLogServiceImpl implements DailySymptomLogService {

    private final DailySymptomLogRepository logRepository;
    private final PatientProfileRepository patientRepository;

    public DailySymptomLogServiceImpl(DailySymptomLogRepository logRepository,
                                      PatientProfileRepository patientRepository) {
        this.logRepository = logRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public DailySymptomLog recordSymptomLog(DailySymptomLog log) {
        patientRepository.findById(log.getPatientId())
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found"));

        if (log.getLogDate() != null && log.getLogDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Future date not allowed");
        }

        logRepository.findByPatientIdAndLogDate(
                log.getPatientId(),
                log.getLogDate()
        ).ifPresent(l -> {
            throw new IllegalArgumentException("Duplicate daily log");
        });

        return logRepository.save(log);
    }

    @Override
    public DailySymptomLog updateSymptomLog(Long id, DailySymptomLog updated) {
        DailySymptomLog existing = logRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Log not found"));

        updated.setId(existing.getId());
        updated.setPatientId(existing.getPatientId());

        return logRepository.save(updated);
    }

    @Override
    public List<DailySymptomLog> getLogsByPatient(Long patientId) {
        return logRepository.findByPatientId(patientId);
    }
}
