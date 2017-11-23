package com.bestway.program.model.pojo.user;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel("用户表")
public class UserPojo implements Serializable {
    @ApiModelProperty(value = "ID")
    private Integer userID;

    @ApiModelProperty(value = "身份证")
    private String idNumber;

    @ApiModelProperty(value = "手机号")
    private String mobile;

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
