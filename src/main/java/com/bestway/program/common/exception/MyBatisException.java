package com.bestway.program.common.exception;

/**
 * 
 * 说明：MyBatis异常
 * 
 * @author J.
 * @version 1.0
 * @date 2017年6月29日
 */
public class MyBatisException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Mybatis异常
	 * 
	 * @param msg
	 * @param e
	 */
	public MyBatisException(String msg, Throwable e) {
		super(msg, e);
	}
}
