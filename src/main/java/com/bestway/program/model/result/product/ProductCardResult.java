package com.bestway.program.model.result.product;

import com.bestway.program.common.base.BaseResult;
import com.bestway.program.model.pojo.home.ProductCards;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "体检卡列表")
public class ProductCardResult extends BaseResult {

    @ApiModelProperty(value = "体检卡")
    private List<ProductCards> productCards;

    public List<ProductCards> getProductCards() {
        return productCards;
    }

    public void setProductCards(List<ProductCards> productCards) {
        this.productCards = productCards;
    }
}
