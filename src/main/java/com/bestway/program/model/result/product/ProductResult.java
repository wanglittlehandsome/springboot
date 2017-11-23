package com.bestway.program.model.result.product;

import com.bestway.program.common.base.BaseResult;
import com.bestway.program.model.pojo.product.DetailForItemFather;
import com.bestway.program.model.pojo.product.Labels;
import com.bestway.program.model.pojo.product.ProductDetail;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "套餐详情")
public class ProductResult extends BaseResult {

    @ApiModelProperty(value = "套餐参数")
    private ProductDetail productDetail;

    public ProductDetail getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(ProductDetail productDetail) {
        this.productDetail = productDetail;
    }
}
