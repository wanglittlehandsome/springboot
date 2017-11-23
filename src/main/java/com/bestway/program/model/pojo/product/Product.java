package com.bestway.program.model.pojo.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "套餐")
public class Product implements Serializable {

    @ApiModelProperty(value = "体检卡ID")
    private Integer cardID;

    @ApiModelProperty(value = "体检卡编号")
    private String cardNumber;

    @ApiModelProperty(value = "套餐id")
    private Integer productID;

    @ApiModelProperty(value = "套餐名")
    private String productName;

    @ApiModelProperty(value = "适用人群")
    private String applyTo;

    @ApiModelProperty(value = "体检卡销售价")
    private Double salePrice;

//    @ApiModelProperty(value = "图片")
//    private String fullPic;

    @ApiModelProperty(value = "标签")
    public List<Labels> labels;

    public List<Labels> getLabels() {
        return labels;
    }

    public void setLabels(List<Labels> labels) {
        this.labels = labels;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getApplyTo() {
        return applyTo;
    }

    public void setApplyTo(String applyTo) {
        this.applyTo = applyTo;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getCardID() {
        return cardID;
    }

    public void setCardID(Integer cardID) {
        this.cardID = cardID;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    //    public String getFullPic() {
//        return fullPic;
//    }
//
//    public void setFullPic(String fullPic) {
//        this.fullPic = fullPic;
//    }
}
