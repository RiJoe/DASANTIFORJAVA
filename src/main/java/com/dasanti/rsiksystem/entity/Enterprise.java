package com.dasanti.rsiksystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enterprise {
    private Integer id;
    private String companyName;
    private String principal;
    private String fillName;
    private String fillNumber;
    private Integer employeeNumber;
    private String Address;
    private String lng;
    private String lat;
    private String note;
    private Integer riskScore;
    private Integer strengthenTraining;
    private String majorSourceOfDanger;
    private String mainRisk;
    private List<ConcreteEvaluation> concreteEvaluationList;
}
