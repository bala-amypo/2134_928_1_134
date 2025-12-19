// File: RecoveryCurveProfileController.java
package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.RecoveryCurveProfile;
import com.example.demo.service.RecoveryCurveProfileService;

@RestController
@RequestMapping("/api/recovery-curves")
public class RecoveryCurveProfileController {

    private final RecoveryCurveProfileService service;

    public RecoveryCurveProfileController(RecoveryCurveProfileService service) {
        this.service = service;
    }

    // CREATE CURVE
    @PostMapping
    public RecoveryCurveProfile create(@RequestBody RecoveryCurveProfile curve) {
        return service.createCurve(curve);
    }

    // GET ALL CURVES
    @GetMapping
    public List<RecoveryCurveProfile> getAll() {
        return service.getAllCurves();
    }

    // GET CURVE BY SURGERY + DAY
    @GetMapping("/lookup")
    public RecoveryCurveProfile lookup(@RequestParam String surgeryType,
                                       @RequestParam Integer dayNumber) {
        return service.getCurveForDay(surgeryType, dayNumber);
    }
}
