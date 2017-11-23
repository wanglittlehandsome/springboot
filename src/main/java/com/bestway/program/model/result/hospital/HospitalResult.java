package com.bestway.program.model.result.hospital;

import com.bestway.program.common.base.BaseResult;
import com.bestway.program.model.pojo.hospital.Hospital;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "医疗机构")
public class HospitalResult extends BaseResult {

    @ApiModelProperty(value = "医疗机构")
    private List<Hospital> hospital;

    public List<Hospital> getHospital() {
        return hospital;
    }

    public void setHospital(List<Hospital> hospital) {
        this.hospital = hospital;
    }
}
