package com.bestway.program.model.result.order;

import com.bestway.program.common.base.BaseResult;
import com.bestway.program.model.pojo.orders.OrderListPojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "体检预约列表")
public class OrderListResult extends BaseResult {

    @ApiModelProperty(value = "体检预约列表")
    private List<OrderListPojo> orderListPojo;

    public List<OrderListPojo> getOrderListPojo() {
        return orderListPojo;
    }

    public void setOrderListPojo(List<OrderListPojo> orderListPojo) {
        this.orderListPojo = orderListPojo;
    }
}
