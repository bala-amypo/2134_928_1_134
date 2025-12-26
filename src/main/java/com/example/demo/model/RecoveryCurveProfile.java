package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "recovery_curve_profiles")
public class RecoveryCurveProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String surgeryType;
    private Integer dayNumber;
    private Integer expectedPainLevel;
    private Integer expectedMobilityLevel;
    private Integer expectedFatigueLevel;

    public RecoveryCurveProfile() {}

    private RecoveryCurveProfile(Builder b) {
        this.id = b.id;
        this.surgeryType = b.surgeryType;
        this.dayNumber = b.dayNumber;
        this.expectedPainLevel = b.expectedPainLevel;
        this.expectedMobilityLevel = b.expectedMobilityLevel;
        this.expectedFatigueLevel = b.expectedFatigueLevel;
    }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private Long id;
        private String surgeryType;
        private Integer dayNumber;
        private Integer expectedPainLevel;
        private Integer expectedMobilityLevel;
        private Integer expectedFatigueLevel;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder surgeryType(String s) { this.surgeryType = s; return this; }
        public Builder dayNumber(Integer d) { this.dayNumber = d; return this; }
        public Builder expectedPainLevel(Integer p) { this.expectedPainLevel = p; return this; }
        public Builder expectedMobilityLevel(Integer m) { this.expectedMobilityLevel = m; return this; }
        public Builder expectedFatigueLevel(Integer f) { this.expectedFatigueLevel = f; return this; }

        public RecoveryCurveProfile build() { return new RecoveryCurveProfile(this); }
    }

    public Long getId() { return id; }
    public String getSurgeryType() { return surgeryType; }
    public Integer getDayNumber() { return dayNumber; }
    public Integer getExpectedPainLevel() { return expectedPainLevel; }
    public Integer getExpectedMobilityLevel() { return expectedMobilityLevel; }
    public Integer getExpectedFatigueLevel() { return expectedFatigueLevel; }
}
