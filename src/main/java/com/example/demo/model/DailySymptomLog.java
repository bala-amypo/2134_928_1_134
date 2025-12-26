package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class DailySymptomLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long patientId;
    private Integer painLevel;
    private Integer mobilityLevel;
    private Integer fatigueLevel;
    private String additionalNotes;
    private LocalDate logDate;

    public DailySymptomLog() {}

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final DailySymptomLog d = new DailySymptomLog();

        public Builder id(Long id) {
            d.setId(id);
            return this;
        }

        public Builder patientId(Long patientId) {
            d.setPatientId(patientId);
            return this;
        }

        public Builder painLevel(Integer painLevel) {
            d.setPainLevel(painLevel);
            return this;
        }

        public Builder mobilityLevel(Integer mobilityLevel) {
            d.setMobilityLevel(mobilityLevel);
            return this;
        }

        public Builder fatigueLevel(Integer fatigueLevel) {
            d.setFatigueLevel(fatigueLevel);
            return this;
        }

        public Builder additionalNotes(String notes) {
            d.setAdditionalNotes(notes);
            return this;
        }

        public Builder logDate(LocalDate logDate) {
            d.setLogDate(logDate);
            return this;
        }

        public DailySymptomLog build() {
            return d;
        }
    }

    public Long getId() { return id; }
    public Long getPatientId() { return patientId; }
    public Integer getPainLevel() { return painLevel; }
    public Integer getMobilityLevel() { return mobilityLevel; }
    public Integer getFatigueLevel() { return fatigueLevel; }
    public String getAdditionalNotes() { return additionalNotes; }
    public LocalDate getLogDate() { return logDate; }

    public void setId(Long id) { this.id = id; }
    public void setPatientId(Long patientId) { this.patientId = patientId; }
    public void setPainLevel(Integer painLevel) { this.painLevel = painLevel; }
    public void setMobilityLevel(Integer mobilityLevel) { this.mobilityLevel = mobilityLevel; }
    public void setFatigueLevel(Integer fatigueLevel) { this.fatigueLevel = fatigueLevel; }
    public void setAdditionalNotes(String additionalNotes) { this.additionalNotes = additionalNotes; }
    public void setLogDate(LocalDate logDate) { this.logDate = logDate; }
}
