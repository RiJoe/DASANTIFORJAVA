package com.dasanti.rsiksystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConcreteEvaluation {
    private Integer id;
    private Integer enterpriseId;
    private Integer categoryId;
    private Integer influenceFactorId;
    private String determineFactor;
    private Integer score;
    private String photo;
    private String remark;
}
