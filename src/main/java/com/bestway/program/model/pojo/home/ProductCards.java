package com.bestway.program.model.pojo.home;

import com.bestway.program.model.pojo.product.Product;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "体检卡列表")
public class ProductCards implements Serializable {

    @ApiModelProperty(value = "体检类型")
    private String productType;

//    @ApiModelProperty(value = "体检卡对应的套餐详情")
//    private List<Product> product;

    @ApiModelProperty(value = "体检类型对应的体检卡详情")
    private List<Product> product;


    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }
}
