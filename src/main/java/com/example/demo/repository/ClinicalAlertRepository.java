// File: ClinicalAlertRepository.java
package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.ClinicalAlert;
import com.example.demo.entity.PatientProfile;

public interface ClinicalAlertRepository
        extends JpaRepository<ClinicalAlert, Long> {

    List<ClinicalAlert> findByPatient(PatientProfile patient);

    List<ClinicalAlert> findByResolvedFalse();
}
