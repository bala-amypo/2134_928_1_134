package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "deviation_rules")
public class DeviationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String surgeryType;

    @NotBlank
    private String symptomParameter; // pain | mobility | fatigue

    @NotNull
    @Min(0)
    private Integer thresholdDeviation;

    private Boolean active;

    public DeviationRule() {}

    @PrePersist
    void onCreate() {
        this.active = true;
    }

    // Getters & setters
    public Long getId() { return id; }

    public String getSurgeryType() { return surgeryType; }
    public void setSurgeryType(String surgeryType) { this.surgeryType = surgeryType; }

    public String getSymptomParameter() { return symptomParameter; }
    public void setSymptomParameter(String symptomParameter) {
        this.symptomParameter = symptomParameter;
    }

    public Integer getThresholdDeviation() { return thresholdDeviation; }
    public void setThresholdDeviation(Integer thresholdDeviation) {
        this.thresholdDeviation = thresholdDeviation;
    }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}
