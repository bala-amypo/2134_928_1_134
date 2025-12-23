package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "patient_profiles")
public class PatientProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Patient ID is required")
    @Column(unique = true, nullable = false)
    private String patientId;

    @NotBlank(message = "Full name is required")
    private String fullName;

    @Min(value = 0, message = "Age cannot be negative")
    @Max(value = 120, message = "Age cannot be greater than 120")
    private Integer age;

    @Email(message = "Email must be valid")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "Surgery type is required")
    private String surgeryType;

    private Boolean active;

    private LocalDateTime createdAt;

    /* ---------------- RELATIONSHIPS ---------------- */

    @OneToMany(
            mappedBy = "patient",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnore
    private List<DailySymptomLog> symptomLogs;

    @OneToMany(
            mappedBy = "patient",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnore
    private List<ClinicalAlert> alerts;

    /* ---------------- CONSTRUCTORS ---------------- */

    public PatientProfile() {
    }

    /* ---------------- LIFECYCLE ---------------- */

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
        if (this.active == null) {
            this.active = true;
        }
    }

    /* ---------------- GETTERS & SETTERS ---------------- */

    public Long getId() {
        return id;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSurgeryType() {
        return surgeryType;
    }

    public void setSurgeryType(String surgeryType) {
        this.surgeryType = surgeryType;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
