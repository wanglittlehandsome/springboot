package com.bestway.program.controller.login;

import com.bestway.program.common.base.BaseController;
import com.bestway.program.common.base.BaseResult;
import com.bestway.program.common.config.HttpInvokeConfiguration;
import com.bestway.program.common.utils.HttpClientUtils;
import com.bestway.program.common.utils.Result;
import com.sun.xml.internal.rngom.parse.host.Base;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Api(value = "持卡预约登录")
@RestController
@RequestMapping("/login")
public class LoginController extends BaseController {

    private static Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private HttpInvokeConfiguration httpInvokeConfiguration;

    @ApiOperation(value = "根据体检卡&密码或手机号进行登录", notes = "根据体检卡或手机号进行登录")
    @PostMapping("/loginByCardOrMobile")
    public String loginByCardOrMobile(@ApiParam("卡号/手机号") @RequestParam(required = true) String number,
                                      @ApiParam("密码/验证码") @RequestParam(required = true) String password,
                                      @ApiParam("类型  0-卡号卡密  1-手机号") @RequestParam(required = true) Integer type) {
        BaseResult result = new BaseResult();
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("number", number);
            map.put("password", password);
            map.put("type", type);
            String res = HttpClientUtils.postParameters(httpInvokeConfiguration.getLOGIN(), Result.toJSON(map));
            return res;
        } catch (Exception e) {
            log.error(e.getMessage());
            result.setMessage(ERROR_MSG);
            result.setStatus(ERROR_CODE);
        }
        return Result.toJSON(result);
    }

    @ApiOperation(value = "获取手机验证码", notes = "获取手机验证码", response = BaseResult.class)
    @PostMapping("/getCode")
    public String getCode(@ApiParam("手机号") @RequestParam(required = true) String mobile) {
        BaseResult result = new BaseResult();
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("mobile", mobile);
            String res = HttpClientUtils.postParameters(httpInvokeConfiguration.getCODE(), map);
            return res;
        } catch (Exception e) {
            log.error(e.getMessage());
            result.setMessage(ERROR_MSG);
            result.setStatus(ERROR_CODE);
        }
        return Result.toJSON(result);
    }


}
