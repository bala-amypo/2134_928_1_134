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
    private Integer threshold;
    private Boolean active = true;

    public DeviationRule() {}

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final DeviationRule d = new DeviationRule();

        public Builder id(Long id) {
            d.setId(id);
            return this;
        }

        public Builder ruleCode(String ruleCode) {
            d.setRuleCode(ruleCode);
            return this;
        }

        public Builder parameter(String parameter) {
            d.setParameter(parameter);
            return this;
        }

        public Builder severity(String severity) {
            d.setSeverity(severity);
            return this;
        }

        public Builder threshold(Integer threshold) {
            d.setThreshold(threshold);
            return this;
        }

        public Builder active(Boolean active) {
            d.setActive(active);
            return this;
        }

        public DeviationRule build() {
            return d;
        }
    }

    public Long getId() { return id; }
    public String getRuleCode() { return ruleCode; }
    public String getParameter() { return parameter; }
    public String getSeverity() { return severity; }
    public Integer getThreshold() { return threshold; }
    public Boolean getActive() { return active; }

    public void setId(Long id) { this.id = id; }
    public void setRuleCode(String ruleCode) { this.ruleCode = ruleCode; }
    public void setParameter(String parameter) { this.parameter = parameter; }
    public void setSeverity(String severity) { this.severity = severity; }
    public void setThreshold(Integer threshold) { this.threshold = threshold; }
    public void setActive(Boolean active) { this.active = active; }
}
