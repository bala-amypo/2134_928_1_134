package com.example.demo.repository;

import java.util.*;

public interface ClinicalAlertRecordRepository {
    Optional<ClinicalAlertRecord> findById(Long id);
    List<ClinicalAlertRecord> findByPatientId(Long id);
    List<ClinicalAlertRecord> findAll();
    ClinicalAlertRecord save(ClinicalAlertRecord a);
}
