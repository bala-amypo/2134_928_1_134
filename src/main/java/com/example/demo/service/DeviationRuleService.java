// File: DeviationRuleService.java
package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.DeviationRule;

public interface DeviationRuleService {

    DeviationRule createRule(DeviationRule rule);

    List<DeviationRule> getActiveRules();

    List<DeviationRule> getAllRules();
}
