package com.example.demo.repository;

import java.util.*;

public interface DailySymptomLogRepository {
    Optional<DailySymptomLog> findById(Long id);
    Optional<DailySymptomLog> findByPatientIdAndLogDate(Long id, java.time.LocalDate date);
    List<DailySymptomLog> findByPatientId(Long id);
    DailySymptomLog save(DailySymptomLog log);
}
