package com.bestway.program.model.pojo.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("项目检查")
public class HealthExamSection {

    @ApiModelProperty(value = "项目检查名称")
    private String sectionName;

    @ApiModelProperty(value = "项目描述")
    private String description;

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
