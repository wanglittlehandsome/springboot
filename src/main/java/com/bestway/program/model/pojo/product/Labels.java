package com.bestway.program.model.pojo.product;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "标签详情")
public class Labels {

    @ApiModelProperty(value = "标签ID")
    private Integer labelID;

    @ApiModelProperty(value = "标签名称")
    private String name ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLabelID() {
        return labelID;
    }

    public void setLabelID(Integer labelID) {
        this.labelID = labelID;
    }
}
