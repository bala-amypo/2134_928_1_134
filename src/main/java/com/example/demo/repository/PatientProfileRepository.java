package com.example.demo.repository;

import java.util.*;

public interface PatientProfileRepository {
    Optional<PatientProfile> findById(Long id);
    Optional<PatientProfile> findByPatientId(String patientId);
    List<PatientProfile> findAll();
    PatientProfile save(PatientProfile p);
}
