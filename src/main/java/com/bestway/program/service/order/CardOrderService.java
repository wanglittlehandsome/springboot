package com.bestway.program.service.order;

import com.bestway.program.common.base.TxService;
import com.bestway.program.dao.order.CardOrderDao;
import com.bestway.program.dao.user.UserDao;
import com.bestway.program.model.dto.orders.OrderItemDto;
import com.bestway.program.model.dto.orders.OrderParamDto;
import com.bestway.program.model.dto.orders.OrderReservationDto;
import com.bestway.program.model.dto.user.UserDto;
import com.bestway.program.model.pojo.orders.OrderListPojo;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardOrderService extends TxService {
    private static Logger log = LoggerFactory.getLogger(CardOrderService.class);

    @Autowired
    private CardOrderDao cardOrderDao;
    @Autowired
    private UserDao userDao;

    /**
     * 持卡预约
     *
     * @param orderParamDto
     * @param orderItemDto
     * @param orderReservationDto
     */
    public void doCardOrder(OrderParamDto orderParamDto, OrderItemDto orderItemDto, OrderReservationDto orderReservationDto) {
        //查询user,没有则新增user
        Integer userID = userDao.qeuryUser(orderReservationDto.getMobile());
        if (userID == null) {
            UserDto userDto = new UserDto(orderReservationDto.getIdNumber(), orderReservationDto.getMobile(), orderReservationDto.getSubscriber());
            userDao.insertUser(userDto);
            userID = userDto.getId();
            log.info("新增用户：" + userDto.toString());
        }
        //1.创建订单data
        orderParamDto.setUserID(userID);
        cardOrderDao.insertOrder(orderParamDto);
        log.info("新增订单：" + orderParamDto.toString() + ",用户ID为：" + userID);
        //2.创建订单关联data
        orderItemDto.setOrderID(orderParamDto.getId());
        cardOrderDao.insertOrderItem(orderItemDto);
        log.info("新增订单产品：" + orderItemDto.toString() + ",用户ID为：" + userID);
        //3.创建预约data
        orderReservationDto.setOrderItemID(orderItemDto.getId());
        cardOrderDao.insertOrderReservationDto(orderReservationDto);
        log.info("新增预约：" + orderReservationDto.toString() + ",用户ID为：" + userID);
    }

    /**
     * 获取持卡预约列表
     *
     * @param cardNumber
     * @param mobile
     * @return
     */
    public List<OrderListPojo> queryOrderList(String cardNumber, String mobile) {
        return cardOrderDao.queryOrderList(cardNumber, mobile);
    }
}
