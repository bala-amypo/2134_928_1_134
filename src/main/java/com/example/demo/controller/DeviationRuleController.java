// File: DeviationRuleController.java
package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.DeviationRule;
import com.example.demo.service.DeviationRuleService;

@RestController
@RequestMapping("/api/deviation-rules")
public class DeviationRuleController {

    private final DeviationRuleService service;

    public DeviationRuleController(DeviationRuleService service) {
        this.service = service;
    }

    // CREATE RULE
    @PostMapping
    public DeviationRule createRule(@RequestBody DeviationRule rule) {
        return service.createRule(rule);
    }

    // GET ACTIVE RULES
    @GetMapping("/active")
    public List<DeviationRule> getActiveRules() {
        return service.getActiveRules();
    }

    // GET ALL RULES
    @GetMapping
    public List<DeviationRule> getAllRules() {
        return service.getAllRules();
    }
}
