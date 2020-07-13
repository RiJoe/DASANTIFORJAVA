package com.dasanti.rsiksystem.service.serviceImpl;

import com.dasanti.rsiksystem.entity.ConcreteEvaluation;
import com.dasanti.rsiksystem.entity.Enterprise;
import com.dasanti.rsiksystem.mapper.EnterpriseMapper;
import com.dasanti.rsiksystem.service.EnterpriseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EnterpriseServiceImpl implements EnterpriseService {
    @Resource
    private EnterpriseMapper enterpriseMapper;

    @Override
    public List<Enterprise> getAllEnterprise() {
        return enterpriseMapper.getAllEnterprise();
    }

    @Override
    public Integer getScoreByName(String scoreName) {
        return enterpriseMapper.getScoreByName(scoreName);
    }

    @Override
    public List<ConcreteEvaluation> getConcreteEvaluationById(Integer enterpriseId) {
        return enterpriseMapper.getConcreteEvaluationById(enterpriseId);
    }

    @Override
    public List<Enterprise> getEnterpriseListByName(String name) {
        return enterpriseMapper.getEnterpriseListByName(name);
    }
}
