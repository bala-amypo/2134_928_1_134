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

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private Long id;
        private Long patientId;
        private Long logId;
        private String alertType;
        private String severity;
        private String message;
        private Boolean resolved = false;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder patientId(Long p) { this.patientId = p; return this; }
        public Builder logId(Long l) { this.logId = l; return this; }
        public Builder alertType(String a) { this.alertType = a; return this; }
        public Builder severity(String s) { this.severity = s; return this; }
        public Builder message(String m) { this.message = m; return this; }
        public Builder resolved(Boolean r) { this.resolved = r; return this; }

        public ClinicalAlertRecord build() { return new ClinicalAlertRecord(this); }
    }

    public Long getId() { return id; }
    public Long getPatientId() { return patientId; }
    public Long getLogId() { return logId; }
    public String getAlertType() { return alertType; }
    public String getSeverity() { return severity; }
    public String getMessage() { return message; }
    public Boolean getResolved() { return resolved; }
}
