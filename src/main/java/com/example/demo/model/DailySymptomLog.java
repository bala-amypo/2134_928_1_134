package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class DailySymptomLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer painLevel;
    private LocalDate logDate;

    public DailySymptomLog() {}

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final DailySymptomLog d = new DailySymptomLog();

        public Builder painLevel(Integer p) {
            d.setPainLevel(p);
            return this;
        }

        public Builder logDate(LocalDate l) {
            d.setLogDate(l);
            return this;
        }

        public DailySymptomLog build() {
            return d;
        }
    }

    public Long getId() { return id; }
    public Integer getPainLevel() { return painLevel; }
    public LocalDate getLogDate() { return logDate; }

    public void setId(Long id) { this.id = id; }
    public void setPainLevel(Integer painLevel) { this.painLevel = painLevel; }
    public void setLogDate(LocalDate logDate) { this.logDate = logDate; }
}
