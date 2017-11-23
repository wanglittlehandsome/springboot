package com.bestway.program.controller.product;

import com.bestway.program.common.base.BaseController;
import com.bestway.program.common.utils.Result;
import com.bestway.program.model.pojo.product.ProductCardList;
import com.bestway.program.model.pojo.product.ProductDetail;
import com.bestway.program.model.pojo.product.ProductOrder;
import com.bestway.program.model.result.product.ProductOrderResult;
import com.bestway.program.model.result.product.ProductResult;
import com.bestway.program.service.product.ProductCardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Api(value = "体检卡套餐")
@RestController
@RequestMapping("product")
public class ProductController extends BaseController {

    private Logger logger= LoggerFactory.getLogger(ProductController.class);


    @Autowired
    private ProductCardService productCardService;

    @ApiOperation(value = "套餐详情",notes="套餐详情", response=ProductResult.class)
    @PostMapping("queryProductInfo")
    public String queryProductInfo(@ApiParam("体检卡ID") @RequestParam Integer cardID){
        ProductResult result=new ProductResult();
        try{
            ProductDetail productDetail=productCardService.queryProductInfo(cardID);
            result.setProductDetail(productDetail);
            result.setStatus(SUCCESS_CODE);
            result.setMessage(SUCCESS_MSG);
        }catch(Exception e){
            logger.error(e.getMessage());
            result.setMessage(ERROR_MSG);
            result.setStatus(ERROR_CODE);
        }

        return Result.toJSON(result);
    }


    @ApiOperation(value = "预约体检", notes = "预约体检", response = ProductOrderResult.class)
    @PostMapping("/queryProductOrder")
    public String queryProductOrder(@ApiParam("体检卡号ID") @RequestParam(required = true) Integer cardID) {
        ProductOrderResult result = new ProductOrderResult();
        try {
            ProductOrder productOrder = productCardService.queryProductOrder(cardID);
            result.setProductOrder(productOrder);
            result.setMessage(SUCCESS_MSG);
            result.setStatus(SUCCESS_CODE);
        } catch (Exception e) {
            result.setMessage(ERROR_MSG);
            result.setStatus(ERROR_CODE);
        }
        return Result.toJSON(result);
    }

}
