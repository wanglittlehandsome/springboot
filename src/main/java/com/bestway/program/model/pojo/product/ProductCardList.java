package com.bestway.program.model.pojo.product;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value="体检卡列表")
public class ProductCardList implements Serializable {

    @ApiModelProperty(value="ID")
    private Long id;

    @ApiModelProperty(value = "卡号")
    private String number;

    @ApiModelProperty(value = "卡名")
    private String product;

    @ApiModelProperty(value = "原价")
    private double originalPrice;

    @ApiModelProperty(value = "售价")
    private double salePrice;

    @ApiModelProperty(value = "销售日期")
    @JSONField(format = "yyyy-MM-dd")
    private Date saleDate;

    @ApiModelProperty(value = "有效期")
    @JSONField(format = "yyyy-MM-dd")
    private Date validityDate;

    @ApiModelProperty(value = "状态 0-未使用   1-已使用")
    private Integer status;

    @ApiModelProperty(value = "销售状态  0-未售  1-已售 2-在售")
    private Integer saleStatus;

    @ApiModelProperty(value = "备注")
    private String comment;


}
