package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "patient_profiles",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "patientId"),
                @UniqueConstraint(columnNames = "email")
        }
)
public class PatientProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patientId;
    private String fullName;
    private Integer age;
    private String email;
    private String surgeryType;
    private Boolean active = true;
    private LocalDateTime createdAt;

    // ---------- CONSTRUCTORS ----------
    public PatientProfile() {}

    private PatientProfile(Builder builder) {
        this.id = builder.id;
        this.patientId = builder.patientId;
        this.fullName = builder.fullName;
        this.age = builder.age;
        this.email = builder.email;
        this.surgeryType = builder.surgeryType;
        this.active = builder.active;
        this.createdAt = builder.createdAt;
    }

    // ---------- BUILDER ----------
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String patientId;
        private String fullName;
        private Integer age;
        private String email;
        private String surgeryType;
        private Boolean active = true;
        private LocalDateTime createdAt;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder patientId(String patientId) {
            this.patientId = patientId;
            return this;
        }

        public Builder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder age(Integer age) {
            this.age = age;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder surgeryType(String surgeryType) {
            this.surgeryType = surgeryType;
            return this;
        }

        public Builder active(Boolean active) {
            this.active = active;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public PatientProfile build() {
            return new PatientProfile(this);
        }
    }

    // ---------- GETTERS & SETTERS ----------
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSurgeryType() { return surgeryType; }
    public void setSurgeryType(String surgeryType) { this.surgeryType = surgeryType; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
