package com.bestway.program.dao.order;


import com.bestway.program.model.dto.orders.OrderItemDto;
import com.bestway.program.model.dto.orders.OrderParamDto;
import com.bestway.program.model.dto.orders.OrderReservationDto;
import com.bestway.program.model.pojo.orders.OrderListPojo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 持卡预约
 */
@Repository
public interface CardOrderDao {


    /**
     * 添加持卡预约订单
     *
     * @param dto
     */
    void insertOrder(OrderParamDto dto);

    /**
     * 添加订单关联
     *
     * @param orderItemDto
     */
    void insertOrderItem(OrderItemDto orderItemDto);

    /**
     * 添加订单预约表
     *
     * @param orderReservationDto
     */
    void insertOrderReservationDto(OrderReservationDto orderReservationDto);

    /**
     * 获取持卡预约列表
     * @param cardNumber
     * @param mobile
     * @return
     */
    List<OrderListPojo> queryOrderList(@Param("cardNumber") String cardNumber, @Param("mobile") String mobile);
}
