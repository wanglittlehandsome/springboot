package com.bestway.program.common.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 
 * 说明：日志帮助类
 * 
 * @author J.
 * @version 1.0
 * @date 2017年9月7日
 */
public class LogUtils {

	private LogUtils() {
		throw new IllegalAccessError("Utility class");
	}

	/**
	 * 
	 * 说明：获得异常堆栈信息
	 * 
	 * @author J.
	 * @param e
	 * @return
	 * @time：2017年9月7日 上午10:28:22
	 */
	public static String getExceptionInfo(Exception e) {
		StringWriter writer = new StringWriter();
		e.printStackTrace(new PrintWriter(writer));
		return writer.toString();
	}
}
