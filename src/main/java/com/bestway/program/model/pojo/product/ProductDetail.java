package com.bestway.program.model.pojo.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "套餐详情")
public class ProductDetail implements Serializable{

    //套餐详情》》套餐基本信息，套餐标签，套餐单项检查，套餐医院
    @ApiModelProperty(value = "体检卡ID")
    private Integer cardID;

    @ApiModelProperty(value = "体检卡价格")
    private Double price;

    @ApiModelProperty(value = "套餐id")
    private Long productId;

    @ApiModelProperty(value = "套餐名")
    private String productName;

    @ApiModelProperty(value = "套餐描述")
    private String description;

    @ApiModelProperty(value = "检查")
    public List<DetailForItemFather> detailForItemFather;

    @ApiModelProperty(value = "标签")
    public List<Labels> labels;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCardID() {
        return cardID;
    }

    public void setCardID(Integer cardID) {
        this.cardID = cardID;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<DetailForItemFather> getDetailForItemFather() {
        return detailForItemFather;
    }

    public void setDetailForItemFather(List<DetailForItemFather> detailForItemFather) {
        this.detailForItemFather = detailForItemFather;
    }

    public List<Labels> getLabels() {
        return labels;
    }

    public void setLabels(List<Labels> labels) {
        this.labels = labels;
    }
}
