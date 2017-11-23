package com.bestway.program.model.result.user;

import com.bestway.program.common.base.BaseResult;
import com.bestway.program.model.pojo.user.UserHome;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * 说明：个人中心首页result
 * 
 * @author J.
 * @version 1.0
 * @date 2017年9月11日
 */
@ApiModel(value = "个人中心首页result")
public class UserHomeResult extends BaseResult {

	@ApiModelProperty(value = "个人中心")
	private UserHome home;

	public UserHome getHome() {
		return home;
	}

	public void setHome(UserHome home) {
		this.home = home;
	}

}
