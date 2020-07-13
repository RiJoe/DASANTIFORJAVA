package com.dasanti.rsiksystem.service;

import com.dasanti.rsiksystem.entity.ConcreteEvaluation;
import com.dasanti.rsiksystem.entity.Enterprise;

import java.util.List;

public interface EnterpriseService {
    List<Enterprise> getAllEnterprise();

    Integer getScoreByName(String scoreName);

    List<ConcreteEvaluation> getConcreteEvaluationById(Integer enterpriseId);

    List<Enterprise> getEnterpriseListByName(String name);
}
