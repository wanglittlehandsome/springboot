package com.bestway.program.dao.product;


import com.bestway.program.common.utils.Pagination;
import com.bestway.program.model.pojo.home.ProductCards;
import com.bestway.program.model.pojo.product.ProductCardList;
import com.bestway.program.model.pojo.product.ProductDetail;
import com.bestway.program.model.pojo.product.ProductOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCardDao {

    /**
     * 列表集合
     *
     * @return
     */
    List<ProductCardList> queryProductCardList();


    /**
     * 获取体检卡列表
     * @param productType
     * @return
     */
    List<ProductCards> queryProductCard(@Param("productType") String productType,@Param("page") Pagination page);


    /**
     * 套餐详情
     * @param cardID
     * @return
     */
    ProductDetail queryProductInfo(Integer cardID);

    /**
     * 体检卡预约查询套餐信息及项目检查
     * @param cardID
     * @return
     */
    ProductOrder queryProductOrder(Integer cardID);
}
