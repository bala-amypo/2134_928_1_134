package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ClinicalAlertRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long patientId;
    private Long logId;
    private String alertType;          // ✅ REQUIRED
    private String message;
    private Boolean resolved = false;
    private LocalDateTime triggeredAt;

    public ClinicalAlertRecord() {}

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final ClinicalAlertRecord c = new ClinicalAlertRecord();

        public Builder id(Long id) {
            c.setId(id);
            return this;
        }

        public Builder patientId(Long patientId) {
            c.setPatientId(patientId);
            return this;
        }

        public Builder logId(Long logId) {
            c.setLogId(logId);
            return this;
        }

        public Builder alertType(String alertType) {
            c.setAlertType(alertType);
            return this;
        }

        public Builder message(String message) {
            c.setMessage(message);
            return this;
        }

        public Builder resolved(Boolean resolved) {
            c.setResolved(resolved);
            return this;
        }

        public Builder triggeredAt(LocalDateTime triggeredAt) {
            c.setTriggeredAt(triggeredAt);
            return this;
        }

        public ClinicalAlertRecord build() {
            return c;
        }
    }

    public Long getId() { return id; }
    public Long getPatientId() { return patientId; }
    public Long getLogId() { return logId; }
    public String getAlertType() { return alertType; }
    public String getMessage() { return message; }
    public Boolean getResolved() { return resolved; }
    public LocalDateTime getTriggeredAt() { return triggeredAt; }

    public void setId(Long id) { this.id = id; }
    public void setPatientId(Long patientId) { this.patientId = patientId; }
    public void setLogId(Long logId) { this.logId = logId; }
    public void setAlertType(String alertType) { this.alertType = alertType; }
    public void setMessage(String message) { this.message = message; }
    public void setResolved(Boolean resolved) { this.resolved = resolved; }
    public void setTriggeredAt(LocalDateTime triggeredAt) { this.triggeredAt = triggeredAt; }
}
