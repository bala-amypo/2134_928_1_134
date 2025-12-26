package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class DeviationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleCode;
    private String parameter;
    private String severity;
    private Boolean active = true;

    public DeviationRule() {}

    // ===== BUILDER =====
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final DeviationRule d = new DeviationRule();

        public Builder ruleCode(String r) {
            d.setRuleCode(r);
            return this;
        }

        public Builder parameter(String p) {
            d.setParameter(p);
            return this;
        }

        public Builder severity(String s) {
            d.setSeverity(s);
            return this;
        }

        public Builder active(Boolean a) {
            d.setActive(a);
            return this;
        }

        public DeviationRule build() {
            return d;
        }
    }

    // ===== GETTERS / SETTERS =====
    public Long getId() { return id; }
    public String getRuleCode() { return ruleCode; }
    public String getParameter() { return parameter; }
    public String getSeverity() { return severity; }
    public Boolean getActive() { return active; }

    public void setId(Long id) { this.id = id; }
    public void setRuleCode(String ruleCode) { this.ruleCode = ruleCode; }
    public void setParameter(String parameter) { this.parameter = parameter; }
    public void setSeverity(String severity) { this.severity = severity; }
    public void setActive(Boolean active) { this.active = active; }
}
