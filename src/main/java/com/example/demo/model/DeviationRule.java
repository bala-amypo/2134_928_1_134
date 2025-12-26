package com.example.demo.model;

public class DeviationRule {

    private Long id;
    private String ruleCode;
    private String parameter;
    private Integer threshold;
    private String severity;
    private Boolean active = true;

    public DeviationRule() {}

    public Long getId() {
        return id;
    }

    public String getRuleCode() {
        return ruleCode;
    }

    public String getParameter() {
        return parameter;
    }

    public Integer getThreshold() {
        return threshold;
    }

    public String getSeverity() {
        return severity;
    }

    public Boolean getActive() {
        return active;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
