package com.bestway.program.common.utils;

import org.apache.commons.lang3.RandomUtils;

/**
 * 
 * 说明：验证码
 * 
 * @author J.
 * @version 1.0
 * @date 2017年9月15日
 */
public class CodeUtils {

	private CodeUtils() {
		throw new IllegalAccessError("Utility class");
	}

	/**
	 * 
	 * 说明：生成指定位数的数字随机验证码
	 * 
	 * @author J.
	 * @param length
	 * @return
	 * @time：2017年9月15日下午5:30:41
	 */
	public static String getRandomCode(int length) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			sb.append(RandomUtils.nextInt(0, 10));
		}
		return sb.toString();
	}

}
