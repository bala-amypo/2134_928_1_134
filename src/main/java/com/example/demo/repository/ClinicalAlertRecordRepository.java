package com.example.demo.repository;

import com.example.demo.model.*;
import java.util.*;
public interface ClinicalAlertRecordRepository {
    ClinicalAlertRecord save(ClinicalAlertRecord a);
    Optional<ClinicalAlertRecord> findById(Long id);
    List<ClinicalAlertRecord> findByPatientId(Long pid);
    List<ClinicalAlertRecord> findAll();
}
