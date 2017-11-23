package com.bestway.program.model.pojo.hospital;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel("指定医疗机构")
public class Hospital implements Serializable {

    @ApiModelProperty(value = "医院ID")
    private Integer hospitalID;

    @ApiModelProperty(value = "医院名称")
    private String hospitalName;

    @ApiModelProperty(value = "医院地址")
    private String hospitalAddress;

    @ApiModelProperty(value = "距离")
    private Long juli;

    @ApiModelProperty(value = "距离   单位:km")
    private double distance;

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Long getJuli() {
        return juli;
    }

    public void setJuli(Long juli) {
        this.juli = juli;
    }

    public Integer getHospitalID() {
        return hospitalID;
    }

    public void setHospitalID(Integer hospitalID) {
        this.hospitalID = hospitalID;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHospitalAddress() {
        return hospitalAddress;
    }

    public void setHospitalAddress(String hospitalAddress) {
        this.hospitalAddress = hospitalAddress;
    }
}
