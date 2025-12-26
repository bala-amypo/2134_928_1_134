package com.example.demo.repository;

import com.example.demo.model.*;
import java.util.*;
public interface DeviationRuleRepository {
    DeviationRule save(DeviationRule r);
    Optional<DeviationRule> findById(Long id);
    Optional<DeviationRule> findByRuleCode(String code);
    List<DeviationRule> findByActiveTrue();
}
