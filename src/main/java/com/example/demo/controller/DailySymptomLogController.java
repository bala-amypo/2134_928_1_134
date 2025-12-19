// File: DailySymptomLogController.java
package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.DailySymptomLog;
import com.example.demo.service.DailySymptomLogService;

@RestController
@RequestMapping("/api/symptoms")
public class DailySymptomLogController {

    private final DailySymptomLogService service;

    public DailySymptomLogController(DailySymptomLogService service) {
        this.service = service;
    }

    // SUBMIT DAILY LOG
    @PostMapping
    public DailySymptomLog submitLog(@RequestBody DailySymptomLog log) {
        return service.submitLog(log);
    }

    // GET LOGS BY PATIENT
    @GetMapping("/patient/{patientId}")
    public List<DailySymptomLog> getLogsByPatient(@PathVariable Long patientId) {
        return service.getLogsForPatient(patientId);
    }
}
