package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(
        name = "daily_symptom_logs",
        uniqueConstraints = @UniqueConstraint(columnNames = {"patientId", "logDate"})
)
public class DailySymptomLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long patientId;
    private LocalDate logDate;
    private Integer painLevel;
    private Integer mobilityLevel;
    private Integer fatigueLevel;
    private String additionalNotes;

    public DailySymptomLog() {}

    private DailySymptomLog(Builder b) {
        this.id = b.id;
        this.patientId = b.patientId;
        this.logDate = b.logDate;
        this.painLevel = b.painLevel;
        this.mobilityLevel = b.mobilityLevel;
        this.fatigueLevel = b.fatigueLevel;
        this.additionalNotes = b.additionalNotes;
    }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private Long id;
        private Long patientId;
        private LocalDate logDate;
        private Integer painLevel;
        private Integer mobilityLevel;
        private Integer fatigueLevel;
        private String additionalNotes;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder patientId(Long patientId) { this.patientId = patientId; return this; }
        public Builder logDate(LocalDate logDate) { this.logDate = logDate; return this; }
        public Builder painLevel(Integer painLevel) { this.painLevel = painLevel; return this; }
        public Builder mobilityLevel(Integer mobilityLevel) { this.mobilityLevel = mobilityLevel; return this; }
        public Builder fatigueLevel(Integer fatigueLevel) { this.fatigueLevel = fatigueLevel; return this; }
        public Builder additionalNotes(String notes) { this.additionalNotes = notes; return this; }

        public DailySymptomLog build() { return new DailySymptomLog(this); }
    }

    public Long getId() { return id; }
    public Long getPatientId() { return patientId; }
    public LocalDate getLogDate() { return logDate; }
    public Integer getPainLevel() { return painLevel; }
    public Integer getMobilityLevel() { return mobilityLevel; }
    public Integer getFatigueLevel() { return fatigueLevel; }
    public String getAdditionalNotes() { return additionalNotes; }

    public void setId(Long id) { this.id = id; }
    public void setPatientId(Long patientId) { this.patientId = patientId; }
    public void setLogDate(LocalDate logDate) { this.logDate = logDate; }
    public void setPainLevel(Integer painLevel) { this.painLevel = painLevel; }
    public void setMobilityLevel(Integer mobilityLevel) { this.mobilityLevel = mobilityLevel; }
    public void setFatigueLevel(Integer fatigueLevel) { this.fatigueLevel = fatigueLevel; }
    public void setAdditionalNotes(String additionalNotes) { this.additionalNotes = additionalNotes; }
}
