package com.example.demo.controller;

import com.example.demo.model.RecoveryCurveProfile;
import com.example.demo.service.RecoveryCurveService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recovery-curves")
public class RecoveryCurveController {

    private final RecoveryCurveService service;

    public RecoveryCurveController(RecoveryCurveService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<RecoveryCurveProfile> create(@RequestBody RecoveryCurveProfile profile) {
        return ResponseEntity.ok(service.createCurveEntry(profile));
    }

    @GetMapping("/surgery/{type}")
    public ResponseEntity<List<RecoveryCurveProfile>> getBySurgery(@PathVariable String type) {
        return ResponseEntity.ok(service.getCurveForSurgery(type));
    }

    @GetMapping
    public ResponseEntity<List<RecoveryCurveProfile>> getAll() {
        return ResponseEntity.ok(service.getAllCurves());
    }
}
