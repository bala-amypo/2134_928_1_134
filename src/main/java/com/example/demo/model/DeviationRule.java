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

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private Long id;
        private String ruleCode;
        private String parameter;
        private Integer threshold;
        private String severity;
        private Boolean active = true;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder ruleCode(String c) { this.ruleCode = c; return this; }
        public Builder parameter(String p) { this.parameter = p; return this; }
        public Builder threshold(Integer t) { this.threshold = t; return this; }
        public Builder severity(String s) { this.severity = s; return this; }
        public Builder active(Boolean a) { this.active = a; return this; }

        public DeviationRule build() { return new DeviationRule(this); }
    }

    public Long getId() { return id; }
    public String getRuleCode() { return ruleCode; }
    public String getParameter() { return parameter; }
    public Integer getThreshold() { return threshold; }
    public String getSeverity() { return severity; }
    public Boolean getActive() { return active; }
}
