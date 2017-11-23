package com.bestway.program.model.dto.orders;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 持卡预约参数列表
 */
@ApiModel(value = "订单表")
public class OrderParamDto implements Serializable {
    @ApiModelProperty(value = "订单ID")
    private Integer id;

    @ApiModelProperty(value = "状态ID")
    private Integer status;

    @ApiModelProperty(value = "用户id")
    private Integer userID;

    @ApiModelProperty(value = "订单数量")
    private Integer quantity;

    @ApiModelProperty(value = "总价格")
    private Double totalPrice;

    @ApiModelProperty(value = "实际优惠的总价格")
    private Double totalDiscount;

    @ApiModelProperty(value = "实际支付总价格")
    private Double actualPrice;

    @ApiModelProperty(value = "订单类型")
    private Integer orderType;

    @ApiModelProperty(value = "体检卡号")
    private String cardNumber;

    public OrderParamDto(Double totalPrice, String cardNumber) {
        this.status = 3;//预约中
        this.quantity = 1;
        this.totalPrice = totalPrice;
        this.totalDiscount = 0.0;
        this.actualPrice = 0.0;
        this.orderType = 0;//0-体检卡
        this.cardNumber = cardNumber;
    }

    public Double getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(Double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public Double getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(Double actualPrice) {
        this.actualPrice = actualPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return "OrderParamDto{" +
                "id=" + id +
                ", status=" + status +
                ", userID=" + userID +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                ", totalDiscount=" + totalDiscount +
                ", actualPrice=" + actualPrice +
                ", orderType=" + orderType +
                ", cardNumber='" + cardNumber + '\'' +
                '}';
    }
}
