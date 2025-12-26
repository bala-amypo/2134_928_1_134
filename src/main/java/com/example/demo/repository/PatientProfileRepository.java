package com.example.demo.repository;

import com.example.demo.model.*;
import java.util.*;
public interface PatientProfileRepository {
    PatientProfile save(PatientProfile p);
    Optional<PatientProfile> findById(Long id);
    Optional<PatientProfile> findByPatientId(String pid);
    List<PatientProfile> findAll();
}
