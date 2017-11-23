package com.bestway.program.controller.personal;

import com.bestway.program.common.base.BaseController;
import com.bestway.program.common.base.BaseResult;
import com.bestway.program.common.utils.Result;
import com.bestway.program.model.dto.personal.ReceiverAddressDto;
import com.bestway.program.model.pojo.personal.ReceiverAddressPojo;
import com.bestway.program.model.result.personal.ReceiverAddressResult;
import com.bestway.program.service.personal.PersonalService;
import com.sun.xml.internal.rngom.parse.host.Base;
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

@Api("个人中心")
@RestController
@RequestMapping("/personal")
public class PersonalController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(PersonalController.class);

    @Autowired
    private PersonalService personalService;


    @ApiOperation(value = "收货地址管理", notes = "收货地址管理", response = ReceiverAddressResult.class)
    @PostMapping("/queryAddressManager")
    public String queryAddressManager(@ApiParam("用户ID") @RequestParam(required = true) Integer userID) {
        ReceiverAddressResult result = new ReceiverAddressResult();
        try {
            List<ReceiverAddressDto> list = personalService.queryAddressManager(userID);
            result.setReceiverAddressDto(list);
            result.setMessage(SUCCESS_MSG);
            result.setStatus(SUCCESS_CODE);
        } catch (Exception e) {
            logger.error(e.getMessage());
            result.setMessage(ERROR_MSG);
            result.setStatus(ERROR_CODE);
        }
        return Result.toJSON(result);
    }

    @ApiOperation(value = "新增收货地址", notes = "新增收货地址", response = BaseResult.class)
    @PostMapping("/insertReceiveAddress")
    public String insertReceiveAddress(@ApiParam("用户ID") @RequestParam(required = true) Integer userID,
                                       @ApiParam("收货人") @RequestParam(required = false) String receiverName,
                                       @ApiParam("联系电话") @RequestParam(required = false) String mobile,
                                       @ApiParam("省ID") @RequestParam(required = false) Long province,
                                       @ApiParam("市ID") @RequestParam(required = false) Long city,
                                       @ApiParam("区ID") @RequestParam(required = false) Long district,
                                       @ApiParam("详细地址") @RequestParam(required = false) String address) {
        BaseResult result = new BaseResult();
        try {
            ReceiverAddressDto dto = new ReceiverAddressDto(userID, receiverName, mobile, province, city, district, address);
            personalService.insertReceiveAddress(dto);
            result.setMessage(SUCCESS_MSG);
            result.setStatus(SUCCESS_CODE);
        } catch (Exception e) {
            result.setMessage(ERROR_MSG);
            result.setStatus(ERROR_CODE);
        }
        return Result.toJSON(result);
    }
}
