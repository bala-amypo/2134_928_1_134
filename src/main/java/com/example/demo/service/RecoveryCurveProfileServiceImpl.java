package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.RecoveryCurveProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RecoveryCurveProfileRepository;

@Service
public class RecoveryCurveProfileServiceImpl implements RecoveryCurveProfileService {

    private final RecoveryCurveProfileRepository repo;

    public RecoveryCurveProfileServiceImpl(RecoveryCurveProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public RecoveryCurveProfile createCurve(RecoveryCurveProfile curve) {
        return repo.save(curve);
    }

    @Override
    public RecoveryCurveProfile getCurveForDay(String surgeryType, Integer dayNumber) {
        return repo.findBySurgeryTypeAndDayNumber(surgeryType, dayNumber)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Recovery curve not found for surgeryType: "
                                + surgeryType + ", day: " + dayNumber));
    }

    @Override
    public List<RecoveryCurveProfile> getAllCurves() {
        return repo.findAll();
    }
}
