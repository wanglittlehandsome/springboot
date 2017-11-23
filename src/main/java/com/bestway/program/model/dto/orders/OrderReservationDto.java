package com.bestway.program.model.dto.orders;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单预约表参数
 */
@ApiModel(value = "订单预约人表")
public class OrderReservationDto implements Serializable {

    @ApiModelProperty(value = "预约ID")
    private Integer id;

    @ApiModelProperty(value = "订单套餐关联表ID")
    private Integer orderItemID;

    @ApiModelProperty(value = "预约时间")
    private Date scheduleDate;

    @ApiModelProperty(value = "预约人")
    private String subscriber;

    @ApiModelProperty(value = "电话号码")
    private String mobile;

    @ApiModelProperty(value = "s-身份证， h-护照，j-军官证，")
    private String idType;

    @ApiModelProperty(value = "号码")
    private String idNumber;

    @ApiModelProperty(value = "性别,m-男，f-女已婚，g-女未婚")
    private String sex;

    public OrderReservationDto(Date scheduleDate, String subscriber, String mobile, String idNumber, String sex) {
        this.scheduleDate = scheduleDate;
        this.subscriber = subscriber;
        this.mobile = mobile;
        this.idType = "s";
        this.idNumber = idNumber;
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderItemID() {
        return orderItemID;
    }

    public void setOrderItemID(Integer orderItemID) {
        this.orderItemID = orderItemID;
    }

    public Date getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public String getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(String subscriber) {
        this.subscriber = subscriber;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "OrderReservationDto{" +
                "id=" + id +
                ", orderItemID=" + orderItemID +
                ", scheduleDate=" + scheduleDate +
                ", subscriber='" + subscriber + '\'' +
                ", mobile='" + mobile + '\'' +
                ", idType='" + idType + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
