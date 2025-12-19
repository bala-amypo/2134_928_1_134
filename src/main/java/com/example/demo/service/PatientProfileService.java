// File: PatientProfileService.java
package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.PatientProfile;

public interface PatientProfileService {

    PatientProfile createPatient(PatientProfile patient);

    PatientProfile getPatientById(Long id);

    PatientProfile findByPatientId(String patientId);

    List<PatientProfile> getAllPatients();

    PatientProfile updatePatientStatus(Long id, Boolean active);
}
