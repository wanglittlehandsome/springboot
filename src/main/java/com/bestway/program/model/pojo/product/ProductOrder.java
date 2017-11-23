package com.bestway.program.model.pojo.product;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

@ApiModel(value = "预约体检")
public class ProductOrder {

    @ApiModelProperty(value = "体检卡id")
    private Integer cardID;

    @ApiModelProperty(value = "套餐id")
    private Long productId;

    @ApiModelProperty(value = "套餐名")
    private String productName;

    @ApiModelProperty(value = "图片")
    private String fullPic;

    @ApiModelProperty(value = "有效日期")
    private String validityDate;

    @ApiModelProperty(value = "项目检查")
    private List<HealthExamSection> healthExamSection;

    @ApiModelProperty(value = "单项检查")
    private List<HealthExamItem> healthExamItem;

    public Integer getcardID() {
        return cardID;
    }

    public void setcardID(Integer cardID) {
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

    public String getFullPic() {
        return fullPic;
    }

    public void setFullPic(String fullPic) {
        this.fullPic = fullPic;
    }

    public String getValidityDate() {
        return validityDate;
    }

    public void setValidityDate(String validityDate) {
        this.validityDate = validityDate;
    }

    public List<HealthExamSection> getHealthExamSection() {
        return healthExamSection;
    }

    public void setHealthExamSection(List<HealthExamSection> healthExamSection) {
        this.healthExamSection = healthExamSection;
    }

    public List<HealthExamItem> getHealthExamItem() {
        return healthExamItem;
    }

    public void setHealthExamItem(List<HealthExamItem> healthExamItem) {
        this.healthExamItem = healthExamItem;
    }
}
