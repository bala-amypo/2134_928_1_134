    package com.example.demo.controller;

import com.example.demo.model.RecoveryCurveProfile;
import com.example.demo.service.RecoveryCurveService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recovery-curves")
public class RecoveryCurveController {

    private final RecoveryCurveService recoveryCurveService;

    public RecoveryCurveController(
            RecoveryCurveService recoveryCurveService) {
        this.recoveryCurveService = recoveryCurveService;
    }

    @PostMapping
    public ResponseEntity<RecoveryCurveProfile> create(
            @RequestBody RecoveryCurveProfile curve) {
        return ResponseEntity.ok(
                recoveryCurveService.createCurveEntry(curve));
    }

    @GetMapping("/surgery/{surgeryType}")
    public ResponseEntity<List<RecoveryCurveProfile>> getBySurgery(
            @PathVariable String surgeryType) {
        return ResponseEntity.ok(
                recoveryCurveService.getCurveForSurgery(surgeryType));
    }

    @GetMapping
    public ResponseEntity<List<RecoveryCurveProfile>> getAll() {
        return ResponseEntity.ok(
                recoveryCurveService.getAllCurves());
    }
}
