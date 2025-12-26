package com.example.demo.controller;

import com.example.demo.model.DeviationRule;
import com.example.demo.service.DeviationRuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/deviation-rules")
public class DeviationRuleController {

    private final DeviationRuleService deviationRuleService;

    public DeviationRuleController(
            DeviationRuleService deviationRuleService) {
        this.deviationRuleService = deviationRuleService;
    }

    @PostMapping
    public ResponseEntity<DeviationRule> create(
            @RequestBody DeviationRule rule) {
        return ResponseEntity.ok(
                deviationRuleService.createRule(rule));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeviationRule> update(
            @PathVariable Long id,
            @RequestBody DeviationRule rule) {
        return ResponseEntity.ok(
                deviationRuleService.updateRule(id, rule));
    }

    @GetMapping("/active")
    public ResponseEntity<List<DeviationRule>> getActive() {
        return ResponseEntity.ok(
                deviationRuleService.getActiveRules());
    }

    @GetMapping("/code/{ruleCode}")
    public ResponseEntity<Optional<DeviationRule>> getByCode(
            @PathVariable String ruleCode) {
        return ResponseEntity.ok(
                deviationRuleService.getRuleByCode(ruleCode));
    }

    @GetMapping
    public ResponseEntity<List<DeviationRule>> getAll() {
        return ResponseEntity.ok(
                deviationRuleService.getAllRules());
    }
}
