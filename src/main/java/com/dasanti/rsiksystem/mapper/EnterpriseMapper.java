package com.dasanti.rsiksystem.mapper;

import com.dasanti.rsiksystem.entity.ConcreteEvaluation;
import com.dasanti.rsiksystem.entity.Enterprise;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EnterpriseMapper {
    List<Enterprise> getAllEnterprise();

    Integer getScoreByName(String scoreName);

    List<ConcreteEvaluation> getConcreteEvaluationById(Integer enterpriseId);

    List<Enterprise> getEnterpriseListByName(String name);
}
