package com.example.demo.service.impl;

import com.example.demo.model.RecoveryCurveProfile;
import com.example.demo.repository.RecoveryCurveProfileRepository;
import com.example.demo.service.RecoveryCurveService;

import java.util.Collections;
import java.util.List;

public class RecoveryCurveServiceImpl implements RecoveryCurveService {

    private final RecoveryCurveProfileRepository repository;

    public RecoveryCurveServiceImpl(RecoveryCurveProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public RecoveryCurveProfile createCurveEntry(RecoveryCurveProfile profile) {

        if (profile == null) {
            throw new IllegalArgumentException("Invalid recovery curve profile");
        }

        return repository.save(profile);
    }

    @Override
    public List<RecoveryCurveProfile> getCurveForSurgery(String surgeryType) {

        if (surgeryType == null) {
            return Collections.emptyList();
        }

        List<RecoveryCurveProfile> curves =
                repository.findBySurgeryTypeOrderByDayNumberAsc(surgeryType);

        // Mockito-safe: never return null
        return curves != null ? curves : Collections.emptyList();
    }

    @Override
    public List<RecoveryCurveProfile> getAllCurves() {

        List<RecoveryCurveProfile> curves = repository.findAll();

        // Mockito-safe
        return curves != null ? curves : Collections.emptyList();
    }
}
