package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "deviation_rules")
public class DeviationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleCode;
    private String parameter;
    private Integer threshold;
    private String severity;
    private Boolean active = true;

    public DeviationRule() {}

    private DeviationRule(Builder b) {
        this.id = b.id;
        this.ruleCode = b.ruleCode;
        this.parameter = b.parameter;
        this.threshold = b.threshold;
        this.severity = b.severity;
        this.active = b.active;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String ruleCode;
        private String parameter;
        private Integer threshold;
        private String severity;
        private Boolean active = true;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder ruleCode(String ruleCode) { this.ruleCode = ruleCode; return this; }
        public Builder parameter(String parameter) { this.parameter = parameter; return this; }
        public Builder threshold(Integer threshold) { this.threshold = threshold; return this; }
        public Builder severity(String severity) { this.severity = severity; return this; }
        public Builder active(Boolean active) { this.active = active; return this; }

        public DeviationRule build() {
            return new DeviationRule(this);
        }
    }

    // ✅ GETTERS
    public Long getId() { return id; }
    public String getRuleCode() { return ruleCode; }
    public String getParameter() { return parameter; }
    public Integer getThreshold() { return threshold; }
    public String getSeverity() { return severity; }
    public Boolean getActive() { return active; }

    // ✅ REQUIRED SETTERS (for ServiceImpl)
    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
