package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(
    name = "daily_symptom_logs",
    indexes = {
        @Index(
            name = "idx_patient_date",
            columnList = "patientId, logDate",
            unique = true
        )
    }
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

    public DailySymptomLog() {
    }

    public DailySymptomLog(Long id, Long patientId, LocalDate logDate,
                           Integer painLevel, Integer mobilityLevel,
                           Integer fatigueLevel, String additionalNotes) {
        this.id = id;
        this.patientId = patientId;
        this.logDate = logDate;
        this.painLevel = painLevel;
        this.mobilityLevel = mobilityLevel;
        this.fatigueLevel = fatigueLevel;
        this.additionalNotes = additionalNotes;
    }

    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public Long getPatientId() {
        return patientId;
    }
 
    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }
 
    public LocalDate getLogDate() {
        return logDate;
    }
 
    public void setLogDate(LocalDate logDate) {
        this.logDate = logDate;
    }
 
    public Integer getPainLevel() {
        return painLevel;
    }
 
    public void setPainLevel(Integer painLevel) {
        this.painLevel = painLevel;
    }
 
    public Integer getMobilityLevel() {
        return mobilityLevel;
    }
 
    public void setMobilityLevel(Integer mobilityLevel) {
        this.mobilityLevel = mobilityLevel;
    }
 
    public Integer getFatigueLevel() {
        return fatigueLevel;
    }
 
    public void setFatigueLevel(Integer fatigueLevel) {
        this.fatigueLevel = fatigueLevel;
    }
 
    public String getAdditionalNotes() {
        return additionalNotes;
    }
 
    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }
}
