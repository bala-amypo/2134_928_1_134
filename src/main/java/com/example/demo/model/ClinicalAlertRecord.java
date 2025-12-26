package com.example.demo.model;

public class ClinicalAlertRecord {

    private Long id;
    private Long patientId;
    private Long logId;
    private String alertType;
    private String severity;
    private String message;
    private Boolean resolved = false;

    public ClinicalAlertRecord() {}

    public Long getId() {
        return id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public Long getLogId() {
        return logId;
    }

    public String getAlertType() {
        return alertType;
    }

    public String getSeverity() {
        return severity;
    }

    public String getMessage() {
        return message;
    }

    public Boolean getResolved() {
        return resolved;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setResolved(Boolean resolved) {
        this.resolved = resolved;
    }
}
