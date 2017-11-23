package com.bestway.program.model.result.product;

import com.bestway.program.common.base.BaseResult;
import com.bestway.program.model.pojo.product.ProductOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "体检预约")
public class ProductOrderResult extends BaseResult {

    @ApiModelProperty(value = "体检预约参数")
    private ProductOrder productOrder;

    public ProductOrder getProductOrder() {
        return productOrder;
    }

    public void setProductOrder(ProductOrder productOrder) {
        this.productOrder = productOrder;
    }
}
