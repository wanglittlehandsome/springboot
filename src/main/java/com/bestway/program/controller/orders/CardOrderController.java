package com.bestway.program.controller.orders;


import com.bestway.program.common.base.BaseController;
import com.bestway.program.common.base.BaseResult;
import com.bestway.program.common.config.RabbitMQConfiguration;
import com.bestway.program.common.utils.AmqpSend;
import com.bestway.program.common.utils.FormatUtil;
import com.bestway.program.common.utils.Result;
import com.bestway.program.model.dto.orders.OrderItemDto;
import com.bestway.program.model.dto.orders.OrderParamDto;
import com.bestway.program.model.dto.orders.OrderReservationDto;
import com.bestway.program.model.pojo.orders.OrderListPojo;
import com.bestway.program.model.result.order.OrderListResult;
import com.bestway.program.service.order.CardOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Api(value = "持卡预约")
@RestController
@RequestMapping("/card/order")
public class CardOrderController extends BaseController {

    @Autowired
    private CardOrderService cardOrderService;
    @Autowired
    private RabbitMQConfiguration rabbitMQConfiguration;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @ApiOperation(value = "持卡预约", notes = "持卡预约", response = BaseResult.class)
    @PostMapping("/invokeOrder")
    public String doCardOrder(@ApiParam("体检卡号") @RequestParam(required = true) String cardNumber,
                              @ApiParam("套餐ID") @RequestParam(required = true) Integer productID,
                              @ApiParam("医疗机构") @RequestParam(required = true) Integer healthCenterID,
                              @ApiParam("价格") @RequestParam(required = true) Double price,
                              @ApiParam("体检日期") @RequestParam(required = true) String scheduleDate,
                              @ApiParam("体检人姓名") @RequestParam(required = true) String userName,
                              @ApiParam("身份证号") @RequestParam(required = true) String idNumber,
                              @ApiParam("性别,m-男，f-女已婚，g-女未婚") @RequestParam(required = true) String sex,
                              @ApiParam("手机号码") @RequestParam(required = true) String mobile) {
        BaseResult result = new BaseResult();
        try {
            OrderParamDto orderParamDto = new OrderParamDto(price, cardNumber);
            OrderItemDto orderItemDto = new OrderItemDto(productID, healthCenterID);
            OrderReservationDto orderReservationDto = new OrderReservationDto(FormatUtil.parseToYYYYMMDD(scheduleDate), userName, mobile, idNumber, sex);
            cardOrderService.doCardOrder(orderParamDto, orderItemDto, orderReservationDto);
            result.setMessage(SUCCESS_MSG);
            result.setStatus(SUCCESS_CODE);
        } catch (Exception e) {
            result.setMessage(ERROR_MSG);
            result.setStatus(ERROR_CODE);
        }
        return Result.toJSON(result);
    }

    @ApiOperation(value = "获取体检预约列表", notes = "获取体检预约列表", response = OrderListResult.class)
    @PostMapping("/queryOrderList")
    public String queryOrderList(@ApiParam("体检卡号") @RequestParam(required = false) String cardNumber,
                                 @ApiParam("手机号") @RequestParam(required = false) String mobile) {
        OrderListResult result = new OrderListResult();
        try {
            List<OrderListPojo> list = cardOrderService.queryOrderList(cardNumber, mobile);
            result.setOrderListPojo(list);
            result.setMessage(SUCCESS_MSG);
            result.setStatus(SUCCESS_CODE);
            AmqpSend send = new AmqpSend(Result.toJSON(result), rabbitMQConfiguration, rabbitTemplate);
            send.send();
        } catch (Exception e) {
            result.setMessage(ERROR_MSG);
            result.setStatus(ERROR_CODE);
        }
        return Result.toJSON(result);
    }


}
