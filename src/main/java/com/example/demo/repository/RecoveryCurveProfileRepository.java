package com.example.demo.repository;

import java.util.*;

public interface RecoveryCurveProfileRepository {
    List<RecoveryCurveProfile> findAll();
    List<RecoveryCurveProfile> findBySurgeryTypeOrderByDayNumberAsc(String surgeryType);
    RecoveryCurveProfile save(RecoveryCurveProfile p);
}
