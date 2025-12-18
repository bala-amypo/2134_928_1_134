// File: RecoveryCurveProfileService.java
package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.RecoveryCurveProfile;

public interface RecoveryCurveProfileService {

    RecoveryCurveProfile createCurve(RecoveryCurveProfile curve);

    RecoveryCurveProfile getCurveForDay(String surgeryType, Integer dayNumber);

    List<RecoveryCurveProfile> getAllCurves();
}
