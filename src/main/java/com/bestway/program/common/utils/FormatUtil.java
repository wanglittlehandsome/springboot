package com.bestway.program.common.utils;

import java.math.BigDecimal;
import java.text.*;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * 说明：时间转换工具类
 * 
 * @author J.
 * @version 1.0
 * @date 2017年7月3日
 */
public class FormatUtil {

	/**
	 * 
	 * 说明：根据指定时间格式获取当前时间的字符串
	 * 
	 * @author J.
	 * @param format
	 * @return
	 * @time：2017年7月3日 下午2:53:47
	 */
	public static String getDateTime(String format) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat f = new SimpleDateFormat(format);
		return f.format(cal.getTime());
	}

	/**
	 * 
	 * 说明：根据时间和格式转成字符串
	 * 
	 * @author J.
	 * @param date
	 * @param type
	 * @return
	 * @time：2017年7月3日 下午2:54:23
	 */
	public static String format(Date date, String type) {
		DateFormat format = new SimpleDateFormat(type);
		return format.format(date);
	}

	/**
	 * 
	 * 说明：根据时间转换成年月日字符串
	 * 
	 * @author J.
	 * @param date
	 * @return
	 * @time：2017年7月3日 下午2:56:53
	 */
	public static String format(Date date) {
		return format(date, "yyyy-MM-dd");
	}

	/**
	 * 
	 * 说明：根据时间转换成年月日时分秒字符串
	 * 
	 * @author J.
	 * @param date
	 * @return
	 * @time：2017年7月3日 下午2:58:06
	 */
	public static String formatDataTime(Date date) {
		return format(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 
	 * 说明：根据小数和格式转换成字符串
	 * 
	 * @author J.
	 * @param value
	 * @param type
	 * @return
	 * @time：2017年7月3日 下午2:59:19
	 */
	public static String format(double value, String type) {
		NumberFormat format = new DecimalFormat(type);
		return format.format(value);
	}

	public static String format(BigDecimal value, String type) {
		DecimalFormat format = new DecimalFormat(type);
		return format.format(value);
	}

	public static String format(BigDecimal value) {
		return format(value, "#,##0.00");
	}

	public static String format(double value) {
		return format(value, "#,##0.00");
	}

	public static String format(long value, String type) {
		NumberFormat format = new DecimalFormat(type);
		return format.format(value);
	}

	public static String format(long value) {
		return format(value, "#,###");
	}

	public static String formatCash(String src, int letterNum) {
		src = src.trim();
		String result = "";
		if (src.length() > letterNum) {
			return src.substring((src.length() - letterNum));
		} else {
			while (result.length() < (letterNum - src.length())) {
				result += "0";
			}
			result += src;
			return result;
		}
	}

	public static Date parse(String str) {
		return parse(str, "yyyy-MM-dd HH:mm:ss");
	}

	public static Date parseToYYYYMMDD(String str) {
		return parse(str, "yyyy-MM-dd");
	}

	public static Date parse(String str, String dateType) {
		DateFormat format = new SimpleDateFormat(dateType);
		try {
			return format.parse(str);
		} catch (ParseException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static String formatDateTime(String str) {
		return formatDataTime(parse(str));
	}

	/**
	 * 
	 * 说明：对日期增加天数
	 * 
	 * @author J.
	 * @param payTime
	 * @param day
	 * @return
	 * @throws ParseException
	 * @time：2017年7月3日 下午3:00:38
	 */
	public static String addDate(String payTime, int day) throws ParseException {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = fmt.parse(payTime);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, day);
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cal.getTime());
	}
}
