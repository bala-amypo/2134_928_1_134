package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class DailySymptomLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patientId;
    private Integer painLevel;
    private Integer mobilityLevel;
    private Integer fatigueLevel;
    private LocalDate logDate;

    public DailySymptomLog() {}

    // ===== BUILDER =====
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final DailySymptomLog d = new DailySymptomLog();

        public Builder patientId(String p) {
            d.setPatientId(p);
            return this;
        }

        public Builder painLevel(Integer p) {
            d.setPainLevel(p);
            return this;
        }

        public Builder mobilityLevel(Integer m) {
            d.setMobilityLevel(m);
            return this;
        }

        public Builder fatigueLevel(Integer f) {
            d.setFatigueLevel(f);
            return this;
        }

        public Builder logDate(LocalDate l) {
            d.setLogDate(l);
            return this;
        }

        public DailySymptomLog build() {
            return d;
        }
    }

    // ===== GETTERS / SETTERS =====
    public Long getId() { return id; }
    public String getPatientId() { return patientId; }
    public Integer getPainLevel() { return painLevel; }
    public Integer getMobilityLevel() { return mobilityLevel; }
    public Integer getFatigueLevel() { return fatigueLevel; }
    public LocalDate getLogDate() { return logDate; }

    public void setId(Long id) { this.id = id; }
    public void setPatientId(String patientId) { this.patientId = patientId; }
    public void setPainLevel(Integer painLevel) { this.painLevel = painLevel; }
    public void setMobilityLevel(Integer mobilityLevel) { this.mobilityLevel = mobilityLevel; }
    public void setFatigueLevel(Integer fatigueLevel) { this.fatigueLevel = fatigueLevel; }
    public void setLogDate(LocalDate logDate) { this.logDate = logDate; }
}
