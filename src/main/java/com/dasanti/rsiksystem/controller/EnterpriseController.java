package com.dasanti.rsiksystem.controller;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.dasanti.rsiksystem.entity.ConcreteEvaluation;
import com.dasanti.rsiksystem.entity.Enterprise;
import com.dasanti.rsiksystem.service.EnterpriseService;
import com.dasanti.rsiksystem.util.ResultEntity;
import org.apache.ibatis.binding.MapperMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@RestController
public class EnterpriseController {
    @Resource
    private EnterpriseService enterpriseService;
    // 查询所有企业进行地理分布
    @RequestMapping("/get/enterprise")
    public ResultEntity<List<Enterprise>> getEnterprise(){
        try{
            List<Enterprise> enterprise = enterpriseService.getAllEnterprise();
            for (int i=0;i<enterprise.size();i++){
                try{
                    // 通过企业地址获取百度地图经纬度
                    String address = enterprise.get(i).getAddress();
                    HashMap<String,Object> paramMap = new HashMap<>();
                    paramMap.put("address",address);
                    paramMap.put("output","json");
                    paramMap.put("ak","wFQlNo1lSDLEx8RV6vehHiwLKlx23GNg");
                    String result = HttpUtil.get("http://api.map.baidu.com/geocoding/v3",paramMap);
                    JSONObject jsonObject = JSONObject.parseObject(result);
                    if(jsonObject.getInteger("status") == 0){
                        enterprise.get(i).setLng(jsonObject.getJSONObject("result").getJSONObject("location").getString("lng"));
                        enterprise.get(i).setLat(jsonObject.getJSONObject("result").getJSONObject("location").getString("lat"));

                    }else{
                        enterprise.get(i).setLng(null);
                        enterprise.get(i).setLat(null);
                    }

                }catch(Exception e){
                    e.printStackTrace();

                }
                for (int y=0;y<enterprise.get(i).getConcreteEvaluationList().size();y++){
                    // 获取对应分值进行赋值
                    String scoreName = enterprise.get(i).getConcreteEvaluationList().get(y).getDetermineFactor();
                    Integer score = enterpriseService.getScoreByName(scoreName);
                    enterprise.get(i).getConcreteEvaluationList().get(y).setScore(score);
                }

            }
            
            return ResultEntity.successWithData(enterprise);
        }catch (Exception e){
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        }
    }

    @RequestMapping("/get/concrete/evaluation")
    public ResultEntity<List<ConcreteEvaluation>> getConcreteEvaluation(@RequestParam Integer enterpriseId){
        try {
            System.out.println(enterpriseId);
            // 通过企业id 获取相关评估信息
            List<ConcreteEvaluation> concreteEvaluations =  enterpriseService.getConcreteEvaluationById(enterpriseId);
            for (int i=0;i<concreteEvaluations.size();i++){
                // 通过影响因素设置相应分值
                String scoreName = concreteEvaluations.get(i).getDetermineFactor();
                Integer score = enterpriseService.getScoreByName(scoreName);
                concreteEvaluations.get(i).setScore(score);
            }
            return ResultEntity.successWithData(concreteEvaluations);
        }catch (Exception e){
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        }

    }
    // 通过名字查询企业
    @RequestMapping("/get/enterprise/by/name")
    public ResultEntity<List<Enterprise>> getEnterpriseList(@RequestParam String name){
        try{
            List<Enterprise> enterpriseList = enterpriseService.getEnterpriseListByName(name);
            return ResultEntity.successWithData(enterpriseList);
        }catch (Exception e){
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        }
    }
    // 获取所有企业进行展示
    @RequestMapping("/get/all/enterprise")
    public ResultEntity<List<Enterprise>> getAllEnterpriseList(){
        try{
            List<Enterprise> enterpriseList = enterpriseService.getAllEnterprise();
            return ResultEntity.successWithData(enterpriseList);
        }catch(Exception e){
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        }
    }
}
