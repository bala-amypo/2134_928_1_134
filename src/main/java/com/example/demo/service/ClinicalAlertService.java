// File: ClinicalAlertService.java
package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.ClinicalAlert;

public interface ClinicalAlertService {

    List<ClinicalAlert> getAlertsForPatient(Long patientId);

    List<ClinicalAlert> getUnresolvedAlerts();

    ClinicalAlert resolveAlert(Long id);
}
