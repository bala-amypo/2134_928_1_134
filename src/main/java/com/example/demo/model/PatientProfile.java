package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class PatientProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patientId;
    private String fullName;
    private Integer age;               // ✅ REQUIRED
    private String email;
    private String surgeryType;
    private Boolean active = true;
    private LocalDateTime createdAt;

    public PatientProfile() {}

    // ===== BUILDER =====
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final PatientProfile p = new PatientProfile();

        public Builder id(Long id) {
            p.setId(id);
            return this;
        }

        public Builder patientId(String patientId) {
            p.setPatientId(patientId);
            return this;
        }

        public Builder fullName(String fullName) {
            p.setFullName(fullName);
            return this;
        }

        public Builder age(Integer age) {
            p.setAge(age);
