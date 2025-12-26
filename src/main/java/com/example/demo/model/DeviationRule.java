package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(
    name = "deviation_rules",
    indexes = {
        @Index(
            name = "idx_rule_code",
            columnList = "ruleCode",
            unique = true
        )
    }
)
public class DeviationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String ruleCode;

    private String parameter;
    private Integer threshold;
    private String severity;
    private Boolean active = true;
    private String surgeryType;

    public DeviationRule() {
    }

    public DeviationRule(Long id, String ruleCode, String parameter,
                         Integer threshold, String severity,
                         Boolean active, String surgeryType) {
        this.id = id;
        this.ruleCode = ruleCode;
        this.parameter = parameter;
        this.threshold = threshold;
        this.severity = severity;
        this.active = active;
        this.surgeryType = surgeryType;
    }

    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getRuleCode() {
        return ruleCode;
    }
 
    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode;
    }
 
    public String getParameter() {
        return parameter;
    }
 
    public void setParameter(String parameter) {
        this.parameter = parameter;
    }
 
    public Integer getThreshold() {
        return threshold;
    }
 
    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }
 
    public String getSeverity() {
        return severity;
    }
 
    public void setSeverity(String severity) {
        this.severity = severity;
    }
 
    public Boolean getActive() {
        return active;
    }
 
    public void setActive(Boolean active) {
        this.active = active;
    }
 
    public String getSurgeryType() {
        return surgeryType;
    }
 
    public void setSurgeryType(String surgeryType) {
        this.surgeryType = surgeryType;
    }
}
