// File: RecoveryCurveProfileRepository.java
package com.example.demo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.RecoveryCurveProfile;

public interface RecoveryCurveProfileRepository
        extends JpaRepository<RecoveryCurveProfile, Long> {

    Optional<RecoveryCurveProfile>
    findBySurgeryTypeAndDayNumber(String surgeryType, Integer dayNumber);
}
