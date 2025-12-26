package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ClinicalAlertRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;
    private LocalDateTime triggeredAt;

    public ClinicalAlertRecord() {}

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final ClinicalAlertRecord c = new ClinicalAlertRecord();

        public Builder message(String m) {
            c.setMessage(m);
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

    public Long getId() { return id; }
    public String getMessage() { return message; }
    public LocalDateTime getTriggeredAt() { return triggeredAt; }

    public void setId(Long id) { this.id = id; }
    public void setMessage(String message) { this.message = message; }
    public void setTriggeredAt(LocalDateTime triggeredAt) { this.triggeredAt = triggeredAt; }
}
