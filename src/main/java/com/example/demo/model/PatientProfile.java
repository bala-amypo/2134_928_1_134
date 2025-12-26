package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class PatientProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String surgeryType;
    private boolean active = true;

    public PatientProfile() {}

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getSurgeryType() { return surgeryType; }
    public void setSurgeryType(String surgeryType) { this.surgeryType = surgeryType; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    // ===== BUILDER REQUIRED BY TESTS =====
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final PatientProfile p = new PatientProfile();

        public Builder id(Long id) {
            p.setId(id);
            return this;
        }

        public Builder fullName(String fullName) {
            p.setFullName(fullName);
            return this;
        }

        public Builder surgeryType(String surgeryType) {
            p.setSurgeryType(surgeryType);
            return this;
        }

        public Builder active(boolean active) {
            p.setActive(active);
            return this;
        }

        public PatientProfile build() {
            return p;
        }
    }
}
