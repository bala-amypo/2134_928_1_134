// File: PatientProfileRepository.java
package com.example.demo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.PatientProfile;

public interface PatientProfileRepository
        extends JpaRepository<PatientProfile, Long> {

    Optional<PatientProfile> findByPatientId(String patientId);

    Optional<PatientProfile> findByEmail(String email);

    boolean existsByPatientId(String patientId);

    boolean existsByEmail(String email);
}
