package com.example.demo.model;

public class RecoveryCurveProfile {

    private Long id;
    private String surgeryType;
    private Integer dayNumber;
    private Integer expectedPainLevel;
    private Integer expectedMobilityLevel;
    private Integer expectedFatigueLevel;

    public RecoveryCurveProfile() {}

    public Long getId() {
        return id;
    }

    public String getSurgeryType() {
        return surgeryType;
    }

    public Integer getDayNumber() {
        return dayNumber;
    }

    public Integer getExpectedPainLevel() {
        return expectedPainLevel;
    }

    public Integer getExpectedMobilityLevel() {
        return expectedMobilityLevel;
    }

    public Integer getExpectedFatigueLevel() {
        return expectedFatigueLevel;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSurgeryType(String surgeryType) {
        this.surgeryType = surgeryType;
    }

    public void setDayNumber(Integer dayNumber) {
        this.dayNumber = dayNumber;
    }

    public void setExpectedPainLevel(Integer expectedPainLevel) {
        this.expectedPainLevel = expectedPainLevel;
    }

    public void setExpectedMobilityLevel(Integer expectedMobilityLevel) {
        this.expectedMobilityLevel = expectedMobilityLevel;
    }

    public void setExpectedFatigueLevel(Integer expectedFatigueLevel) {
        this.expectedFatigueLevel = expectedFatigueLevel;
    }
}
