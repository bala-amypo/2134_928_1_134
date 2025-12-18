// File: DailySymptomLogRepository.java
package com.example.demo.repository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.DailySymptomLog;
import com.example.demo.entity.PatientProfile;

public interface DailySymptomLogRepository
        extends JpaRepository<DailySymptomLog, Long> {

    Optional<DailySymptomLog>
    findByPatientAndLogDate(PatientProfile patient, LocalDate logDate);

    List<DailySymptomLog> findByPatient(PatientProfile patient);
}
