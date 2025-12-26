package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class RecoveryCurveProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String surgeryType;
    private Integer dayNumber;
    private Integer expectedPainLevel;

    public RecoveryCurveProfile() {}

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final RecoveryCurveProfile r = new RecoveryCurveProfile();

        public Builder surgeryType(String s) {
            r.setSurgeryType(s);
            return this;
        }

        public Builder dayNumber(Integer d) {
            r.setDayNumber(d);
            return this;
        }

        public Builder expectedPainLevel(Integer p) {
            r.setExpectedPainLevel(p);
            return this;
        }

        public RecoveryCurveProfile build() {
            return r;
        }
    }

    public Long getId() { return id; }
    public String getSurgeryType() { return surgeryType; }
    public Integer getDayNumber() { return dayNumber; }
    public Integer getExpectedPainLevel() { return expectedPainLevel; }

    public void setId(Long id) { this.id = id; }
    public void setSurgeryType(String surgeryType) { this.surgeryType = surgeryType; }
    public void setDayNumber(Integer dayNumber) { this.dayNumber = dayNumber; }
    public void setExpectedPainLevel(Integer expectedPainLevel) { this.expectedPainLevel = expectedPainLevel; }
}
