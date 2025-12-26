package com.example.demo.repository;

import com.example.demo.model.*;
import java.util.*;
public interface RecoveryCurveProfileRepository {
    RecoveryCurveProfile save(RecoveryCurveProfile c);
    List<RecoveryCurveProfile> findBySurgeryTypeOrderByDayNumberAsc(String type);
    List<RecoveryCurveProfile> findAll();
}
