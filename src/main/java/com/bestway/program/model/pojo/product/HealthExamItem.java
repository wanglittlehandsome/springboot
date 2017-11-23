package com.bestway.program.model.pojo.product;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "单项检查")
public class HealthExamItem {


    @ApiModelProperty(value = "单项检查名称")
    private String itemName;


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
