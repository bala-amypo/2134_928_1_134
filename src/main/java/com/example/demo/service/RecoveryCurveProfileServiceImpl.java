// File: RecoveryCurveProfileServiceImpl.java
package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.entity.RecoveryCurveProfile;
import com.example.demo.repository.RecoveryCurveProfileRepository;

@Service
public class RecoveryCurveProfileServiceImpl implements RecoveryCurveProfileService {

    private final RecoveryCurveProfileRepository repo;

    public RecoveryCurveProfileServiceImpl(RecoveryCurveProfileRepository repo) {
        this.repo = repo;
    }

    public RecoveryCurveProfile createCurve(RecoveryCurveProfile curve) {
        return repo.save(curve);
    }

    public RecoveryCurveProfile getCurveForDay(String surgeryType, Integer dayNumber) {
        return repo.findBySurgeryTypeAndDayNumber(surgeryType, dayNumber)
                .orElseThrow();
    }

    public List<RecoveryCurveProfile> getAllCurves() {
        return repo.findAll();
    }
}
