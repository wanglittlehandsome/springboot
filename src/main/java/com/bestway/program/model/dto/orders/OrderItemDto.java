package com.bestway.program.model.dto.orders;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 订单关联表参数
 */
@ApiModel("订单产品关联表")
public class OrderItemDto implements Serializable {
    @ApiModelProperty(value = "订单产品ID")
    private Integer id;

    @ApiModelProperty(value = "订单ID")
    private Integer orderID;

    @ApiModelProperty(value = "产品ID")
    private Integer productID;

    @ApiModelProperty(value = "医院Id")
    private Integer provider;

    @ApiModelProperty(value = "服务商类型")
    private String providerType;

    public OrderItemDto(Integer productID, Integer healthCenterID) {
        this.productID = productID;
        this.provider = healthCenterID;
        this.providerType = "h";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public Integer getProvider() {
        return provider;
    }

    public void setProvider(Integer provider) {
        this.provider = provider;
    }

    public String getProviderType() {
        return providerType;
    }

    public void setProviderType(String providerType) {
        this.providerType = providerType;
    }

    @Override
    public String toString() {
        return "OrderItemDto{" +
                "id=" + id +
                ", orderID=" + orderID +
                ", productID=" + productID +
                ", provider=" + provider +
                ", providerType=" + providerType +
                '}';
    }
}
