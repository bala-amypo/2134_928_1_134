package com.example.demo.repository;

import com.example.demo.model.*;
import java.util.*;
public interface DailySymptomLogRepository {
    DailySymptomLog save(DailySymptomLog log);
    Optional<DailySymptomLog> findById(Long id);
    Optional<DailySymptomLog> findByPatientIdAndLogDate(Long pid, java.time.LocalDate date);
    List<DailySymptomLog> findByPatientId(Long pid);
}
