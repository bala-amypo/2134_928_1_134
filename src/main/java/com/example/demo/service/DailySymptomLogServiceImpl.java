package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.DailySymptomLog;
import com.example.demo.entity.PatientProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.DailySymptomLogRepository;
import com.example.demo.repository.PatientProfileRepository;

@Service
public class DailySymptomLogServiceImpl implements DailySymptomLogService {

    private final DailySymptomLogRepository logRepo;
    private final PatientProfileRepository patientRepo;

    public DailySymptomLogServiceImpl(DailySymptomLogRepository logRepo,
                                      PatientProfileRepository patientRepo) {
        this.logRepo = logRepo;
        this.patientRepo = patientRepo;
    }

    @Override
    public DailySymptomLog submitLog(DailySymptomLog log) {
        return logRepo.save(log);
    }

    @Override
    public List<DailySymptomLog> getLogsForPatient(Long patientId) {
        PatientProfile patient = patientRepo.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Patient not found with id: " + patientId));

        return logRepo.findByPatient(patient);
    }
}
