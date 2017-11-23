package com.bestway.program.common.base;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * 说明：result父类
 * 
 * @author J.
 * @version 1.0
 * @date 2017年7月3日
 */
public class BaseResult {

	@ApiModelProperty(value = "返回状态", required = true)
	protected int status;

	@ApiModelProperty(value = "返回信息", required = true)
	protected String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
