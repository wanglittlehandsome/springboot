package com.bestway.program.controller.hospital;


import com.bestway.program.common.base.BaseController;
import com.bestway.program.common.utils.Result;
import com.bestway.program.model.pojo.hospital.Hospital;
import com.bestway.program.model.pojo.product.ProductOrder;
import com.bestway.program.model.result.hospital.HospitalResult;
import com.bestway.program.model.result.product.ProductOrderResult;
import com.bestway.program.service.hospital.HospitalService;
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

@Api(value = "医疗机构")
@RestController
@RequestMapping("/hospital")
public class HospitalController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(HospitalController.class);

    @Autowired
    private HospitalService hospitalService;


    //获取医疗机构
    @ApiOperation(value = "获取医疗机构", notes = "获取医疗机构", response = HospitalResult.class)
    @PostMapping("/queryAppointHospital")
    public String queryAppointHospital(@ApiParam("纬度") @RequestParam(required = false) Double latitude,
                                       @ApiParam("经度") @RequestParam(required = false) Double longitude,
                                       @ApiParam("卡号ID") @RequestParam(required = false) Integer cardID) {
        HospitalResult result = new HospitalResult();
        // 设置默认上海的经纬度
        if (latitude == null) {
            latitude = 31.23;
        }
        if (longitude == null) {
            longitude = 121.47;
        }
        try {
            List<Hospital> list = hospitalService.queryAppointHospital(latitude, longitude, cardID);
            result.setHospital(list);
            result.setMessage(SUCCESS_MSG);
            result.setStatus(SUCCESS_CODE);
        } catch (Exception e) {
            result.setMessage(ERROR_MSG);
            result.setStatus(ERROR_CODE);
        }
        return Result.toJSON(result);

    }



}
