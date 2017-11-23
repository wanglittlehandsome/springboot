package com.bestway.program.common.exception;

/**
 * 
 * 说明：Redis配置异常
 * 
 * @author J.
 * @version 1.0
 * @date 2017年8月18日
 */
public class RedisConfigException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Redis配置异常
	 * 
	 * @param msg
	 */
	public RedisConfigException(String msg) {
		super(msg);
	}
}
