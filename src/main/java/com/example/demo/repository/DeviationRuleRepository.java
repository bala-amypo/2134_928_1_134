// File: DeviationRuleRepository.java
package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.DeviationRule;

public interface DeviationRuleRepository
        extends JpaRepository<DeviationRule, Long> {

    List<DeviationRule> findByActiveTrue();

    List<DeviationRule> findBySurgeryType(String surgeryType);
}
