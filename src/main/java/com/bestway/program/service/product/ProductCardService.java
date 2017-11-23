package com.bestway.program.service.product;

import com.bestway.program.common.base.TxService;
import com.bestway.program.common.utils.Pagination;
import com.bestway.program.dao.product.ProductCardDao;
import com.bestway.program.model.pojo.home.ProductCards;
import com.bestway.program.model.pojo.product.ProductCardList;
import com.bestway.program.model.pojo.product.ProductDetail;
import com.bestway.program.model.pojo.product.ProductOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductCardService extends TxService {

    @Autowired
    private ProductCardDao cardDao;

    public List<ProductCardList> queryProductCardList() {
        return cardDao.queryProductCardList();
    }


    /**
     * 获取体检卡列表
     *
     * @param productType
     * @return
     */
    public List<ProductCards> queryProductCard(String productType, Pagination page) {
        return cardDao.queryProductCard(productType, page);
    }


    /**
     * 套餐详情
     *
     * @param cardID
     * @return
     */
    public ProductDetail queryProductInfo(Integer cardID) {
        if (cardID == null)
            return null;
        return cardDao.queryProductInfo(cardID);
    }

    /**
     * 体检卡预约查询套餐信息及项目检查
     *
     * @param cardID
     * @return
     */
    public ProductOrder queryProductOrder(Integer cardID) {
        return cardDao.queryProductOrder(cardID);
    }

}
