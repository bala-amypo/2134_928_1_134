package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.DeviationRule;
import com.example.demo.repository.DeviationRuleRepository;

@Service
public class DeviationRuleServiceImpl implements DeviationRuleService {

    private final DeviationRuleRepository repo;

    public DeviationRuleServiceImpl(DeviationRuleRepository repo) {
        this.repo = repo;
    }

    @Override
    public DeviationRule createRule(DeviationRule rule) {
        return repo.save(rule);
    }

    @Override
    public List<DeviationRule> getActiveRules() {
        return repo.findByActiveTrue();
    }

    @Override
    public List<DeviationRule> getAllRules() {
        return repo.findAll();
    }
}
