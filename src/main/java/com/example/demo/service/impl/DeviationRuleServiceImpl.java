package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.DeviationRule;
import com.example.demo.repository.DeviationRuleRepository;
import com.example.demo.service.DeviationRuleService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class DeviationRuleServiceImpl implements DeviationRuleService {

    private final DeviationRuleRepository repository;

    public DeviationRuleServiceImpl(DeviationRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public DeviationRule createRule(DeviationRule rule) {

        if (rule == null) {
            throw new IllegalArgumentException("Invalid rule");
        }

        return repository.save(rule);
    }

    @Override
    public Optional<DeviationRule> getRuleByCode(String ruleCode) {

        if (ruleCode == null) {
            return Optional.empty();
        }

        return repository.findByRuleCode(ruleCode);
    }

    @Override
    public List<DeviationRule> getActiveRules() {

        List<DeviationRule> rules = repository.findByActiveTrue();

        // Mockito-safe: never return null
        return rules != null ? rules : Collections.emptyList();
    }

    @Override
    public DeviationRule updateRule(Long id, DeviationRule updatedRule) {

        if (updatedRule == null) {
            throw new IllegalArgumentException("Invalid rule");
        }

        DeviationRule existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rule not found"));

        // Preserve identity
        existing.setRuleCode(updatedRule.getRuleCode());
        existing.setParameter(updatedRule.getParameter());
        existing.setThreshold(updatedRule.getThreshold());
        existing.setSeverity(updatedRule.getSeverity());
        existing.setActive(updatedRule.getActive());

        return repository.save(existing);
    }
}
