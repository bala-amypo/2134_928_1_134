// File: DailySymptomLogService.java
package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.DailySymptomLog;

public interface DailySymptomLogService {

    DailySymptomLog submitLog(DailySymptomLog log);

    List<DailySymptomLog> getLogsForPatient(Long patientId);
}
