package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ClinicalAlertRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;
    private Boolean resolved = false;
    private LocalDateTime triggeredAt;

    public ClinicalAlertRecord() {}

    // ===== BUILDER =====
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final ClinicalAlertRecord c = new ClinicalAlertRecord();

        public Builder message(String m) {
            c.setMessage(m);
            return this;
        }

        public Builder resolved(Boolean r) {
            c.setResolved(r);
            return this;
        }

        public Builder triggeredAt(LocalDateTime t) {
            c.setTriggeredAt(t);
            return this;
        }

        public ClinicalAlertRecord build() {
            return c;
        }
    }

    // ===== GETTERS / SETTERS =====
    public Long getId() { return id; }
    public String getMessage() { return message; }
    public Boolean getResolved() { return resolved; }
    public LocalDateTime getTriggeredAt() { return triggeredAt; }

    public void setId(Long id) { this.id = id; }
    public void setMessage(String message) { this.message = message; }
    public void setResolved(Boolean resolved) { this.resolved = resolved; }
    public void setTriggeredAt(LocalDateTime triggeredAt) { this.triggeredAt = triggeredAt; }
}
