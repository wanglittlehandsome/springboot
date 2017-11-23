package com.bestway.program.controller.home;

import com.bestway.program.common.base.BaseController;
import com.bestway.program.common.utils.Pagination;
import com.bestway.program.common.utils.Result;
import com.bestway.program.model.pojo.home.ProductCards;
import com.bestway.program.model.result.product.ProductCardResult;
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

@Api(value = "首页")
@RestController
@RequestMapping("home")
public class HomeController extends BaseController {


    private Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private ProductCardService productCardService;


    @ApiOperation(value = "首页体检卡列表", notes = "首页体检卡列表",response = ProductCardResult.class)
    @PostMapping("queryProductCards")
    public String queryProductCards(@ApiParam("体检类型") @RequestParam(required = false) String productType,
                                    @ApiParam("页数") @RequestParam(required = true) Integer start) {
        ProductCardResult result = new ProductCardResult();
        Pagination page=new Pagination();
        page.setPage(start+1);
        try {
            List<ProductCards> list = productCardService.queryProductCard(productType,page);
            result.setProductCards(list);
            result.setMessage(SUCCESS_MSG);
            result.setStatus(SUCCESS_CODE);
        } catch (Exception e) {
            logger.error(e.getMessage());
            result.setMessage(ERROR_MSG);
            result.setStatus(ERROR_CODE);
        }
        return Result.toJSON(result);

    }
}
