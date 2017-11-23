package com.bestway.program.common.utils;

/**
 * 
 * 说明：拼接字符串
 * 
 * @author J.
 * @version 1.0
 * @date 2017年9月4日
 */
public class StringBuilderUtils {

	/**
	 * 
	 * 说明：拼接字符串
	 * 
	 * @author J.
	 * @return
	 * @time：2017年9月4日 下午4:05:19
	 */
	public static String jointChar(String province, String city, String district, String address) {

		// 字符串拼接
		StringBuilder sb = new StringBuilder();
		if (StringUtils.isNotEmpty(province)) {
			sb.append(province);
		}
		if (StringUtils.isNotEmpty(city)) {
			sb.append(city);
		}
		if (StringUtils.isNotEmpty(district)) {
			sb.append(district);
		}
		if (StringUtils.isNotEmpty(address)) {
			sb.append(address);
		}
		return sb.toString();
	}

}
