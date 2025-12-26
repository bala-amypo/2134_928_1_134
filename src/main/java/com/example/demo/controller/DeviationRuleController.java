package com.example.demo.controller;

import com.example.demo.model.DeviationRule;
import com.example.demo.service.DeviationRuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deviation-rules")
public class DeviationRuleController {

    private final DeviationRuleService service;

    public DeviationRuleController(DeviationRuleService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DeviationRule> create(@RequestBody DeviationRule rule) {
        return ResponseEntity.ok(service.createRule(rule));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeviationRule> update(
            @PathVariable Long id,
            @RequestBody DeviationRule rule) {
        return ResponseEntity.ok(service.updateRule(id, rule));
    }

    @GetMapping("/active")
    public ResponseEntity<List<DeviationRule>> getActiveRules() {
        return ResponseEntity.ok(service.getActiveRules());
    }

    @GetMapping("/{code}")
    public ResponseEntity<DeviationRule> getByCode(@PathVariable String code) {
        return service.getRuleByCode(code)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
