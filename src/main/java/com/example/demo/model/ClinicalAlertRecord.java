package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "clinical_alerts")
public class ClinicalAlertRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long patientId;
    private Long logId;
    private String alertType;
    private String severity;
    private String message;
    private Boolean resolved = false;

    public ClinicalAlertRecord() {}

    private ClinicalAlertRecord(Builder b) {
        this.id = b.id;
        this.patientId = b.patientId;
        this.logId = b.logId;
        this.alertType = b.alertType;
        this.severity = b.severity;
        this.message = b.message;
        this.resolved = b.resolved;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private Long patientId;
        private Long logId;
        private String alertType;
        private String severity;
        private String message;
        private Boolean resolved = false;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder patientId(Long patientId) { this.patientId = patientId; return this; }
        public Builder logId(Long logId) { this.logId = logId; return this; }
        public Builder alertType(String alertType) { this.alertType = alertType; return this; }
        public Builder severity(String severity) { this.severity = severity; return this; }
        public Builder message(String message) { this.message = message; return this; }
        public Builder resolved(Boolean resolved) { this.resolved = resolved; return this; }

        public ClinicalAlertRecord build() {
            return new ClinicalAlertRecord(this);
        }
    }

    // ✅ GETTERS
    public Long getId() { return id; }
    public Long getPatientId() { return patientId; }
    public Long getLogId() { return logId; }
    public String getAlertType() { return alertType; }
    public String getSeverity() { return severity; }
    public String getMessage() { return message; }
    public Boolean getResolved() { return resolved; }

    // ✅ REQUIRED SETTER
    public void setResolved(Boolean resolved) {
        this.resolved = resolved;
    }
}
