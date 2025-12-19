// File: DailySymptomLogServiceImpl.java
package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.entity.DailySymptomLog;
import com.example.demo.entity.PatientProfile;
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

    public DailySymptomLog submitLog(DailySymptomLog log) {
        return logRepo.save(log);
    }

    public List<DailySymptomLog> getLogsForPatient(Long patientId) {
        PatientProfile patient = patientRepo.findById(patientId).orElseThrow();
        return logRepo.findByPatient(patient);
    }
}
