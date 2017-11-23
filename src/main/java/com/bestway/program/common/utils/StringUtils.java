package com.bestway.program.common.utils;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.math.BigDecimal;
import java.nio.channels.FileChannel;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author Lizhong Kuang
 * @Modify Date 16/3/10 下午4:50
 */

public class StringUtils {

	/**
	 * 
	 * 说明：判断对象是否为空( 实用于对如下对象做判断:String Collection及其子类 Map及其子类)
	 * 
	 * @author J.
	 * @param pObj
	 * @return
	 * @time：2017年7月18日 下午3:57:02
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(Object pObj) {
		if (pObj == null)
			return true;
		if ("".equals(pObj))
			return true;
		if (pObj instanceof String) {
			if (((String) pObj).length() == 0) {
				return true;
			}
		} else if (pObj instanceof Collection) {
			if (((Collection) pObj).size() == 0) {
				return true;
			}
		} else if (pObj instanceof Map) {
			if (((Map) pObj).size() == 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * 说明：判断对象是否非空( 实用于对如下对象做判断:String Collection及其子类 Map及其子类)
	 * 
	 * @author J.
	 * @param pObj
	 * @return
	 * @time：2017年7月18日 下午3:57:56
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isNotEmpty(Object pObj) {
		if (pObj == null)
			return false;
		if ("".equals(pObj))
			return false;
		if (pObj instanceof String) {
			if (((String) pObj).length() == 0) {
				return false;
			}
		} else if (pObj instanceof Collection) {
			if (((Collection) pObj).size() == 0) {
				return false;
			}
		} else if (pObj instanceof Map) {
			if (((Map) pObj).size() == 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * 说明：判断list是否为空
	 * 
	 * @author J.
	 * @param list
	 * @return
	 * @time：2017年8月21日 下午7:47:50
	 */
	public static boolean isListEmptyOrNull(List<?> list) {
		return list == null || list.isEmpty();
	}

	/**
	 * 
	 * 说明：判断数组是否为空
	 * 
	 * @author J.
	 * @param obj
	 * @return
	 * @time：2017年8月21日 下午7:48:05
	 */
	public static boolean isArrayEmptyOrNull(Object[] obj) {
		return obj == null || obj.length <= 0;
	}

	/**
	 * 
	 * 说明：获取32位小写UUID
	 * 
	 * @author J.
	 * @return
	 * @time：2017年8月18日 下午4:21:48
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	/**
	 * 
	 * 说明：获取当前时间
	 * 
	 * @author J.
	 * @return
	 * @time：2017年7月18日 下午3:59:42
	 */
	public static String getTodayString() {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		return f.format(c.getTime());
	}

	/**
	 * 将一个毫秒数时间转换为相应的时间格式
	 *
	 * @param longSecond
	 * @return
	 */
	public static String formateDateLongToString(long longSecond) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTimeInMillis(longSecond);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(gc.getTime());
	}

	/**
	 * 将一个秒数时间转换为相应的时间格式
	 *
	 * @param longSecond
	 * @return
	 */
	public static String formateDateLongToString1(long longSecond) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTimeInMillis(longSecond * 1000);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(gc.getTime());
	}

	public static String formateDateLongToString(long longSecond, String formatPatten) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTimeInMillis(longSecond);
		if (StringUtils.isEmpty(formatPatten)) {
			formatPatten = "yyyy-MM-dd HH:mm:ss";
		}
		SimpleDateFormat format = new SimpleDateFormat(formatPatten);
		return format.format(gc.getTime());
	}

	/**
	 * 格式化金额.
	 *
	 * @param value
	 *            the value
	 * @return the string
	 */
	public static String formatCurrency2String(Long value) {
		if (value == null || "0".equals(String.valueOf(value))) {
			return "0.00";
		}
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(value / 100.00);
	}

	/**
	 * 格式化金额.
	 *
	 * @param priceFormat
	 *            the price format
	 * @return the long
	 */
	public static Long formatCurrency2Long(String priceFormat) {
		BigDecimal bg = new BigDecimal(priceFormat);
		Long price = bg.multiply(new BigDecimal(100)).longValue();
		return price;
	}

	/**
	 * 获取当前时间.
	 *
	 * @param
	 * @return
	 * @throws
	 */
	public static String getToDayStr() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}

	/**
	 * 获取相对时间，如：昨天 13:00
	 * 
	 * @param seconed
	 * @return
	 */
	public static String getRelativeDateStr(Long seconed) {
		Date date = new Date(seconed);
		Date now = new Date();
		String time = formateDateLongToString(seconed, "YYYY-MM-dd HH:mm");
		if (date.getYear() != now.getYear() || date.getMonth() != now.getMonth() || now.getDay() - date.getDay() > 2)
			return time;
		if (now.getDay() - date.getDay() == 2) {
			return "前天 " + time.split(" ")[1];
		} else if (now.getDay() - date.getDay() == 1) {
			return "昨天 " + time.split(" ")[1];
		}
		return "今天 " + time.split(" ")[1];
	}

	/**
	 * 比较两个日期大小
	 * 
	 * @param DATE1
	 * @param DATE2
	 * @return DATE1>DATE2 1;DATE1<DATE2 -1;DATE1=DATE2 0;
	 */
	public static int compare_date(String DATE1, String DATE2) {

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			Date dt1 = df.parse(DATE1);
			Date dt2 = df.parse(DATE2);
			if (dt1.getTime() > dt2.getTime()) {
				System.out.println("dt1 在dt2前");
				return 1;
			} else if (dt1.getTime() < dt2.getTime()) {
				System.out.println("dt1在dt2后");
				return -1;
			} else {
				return 0;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return 0;
	}

	/**
	 * 获取当前时间当作文件名称
	 *
	 * @return
	 */
	public static String getToDayStrAsFileName() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return sdf.format(new Date());
	}

	/**
	 * 获取当前时间当作文件名称
	 *
	 * @return
	 */
	public static String getToDayStrAsDownloadTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");
		return sdf.format(new Date());
	}

	public static Date getToDay() throws ParseException {
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// Date date = sdf.parse(String.valueOf(System.currentTimeMillis()));
		return new Date();
	}

	/**
	 * 获取下一天.
	 *
	 * @param currentDate
	 *            the current date
	 * @return the next date str
	 * @throws ParseException
	 *             the parse exception
	 */
	public static String getNextDateStr(String currentDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date date = sdf.parse(currentDate);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, 1);
		String nextDate = sdf.format(calendar.getTime());
		return nextDate;
	}

	public static String getNextNday(String currentDate, Integer n) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = sdf.parse(currentDate);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.DATE, n);
			return sdf.format(calendar.getTime());

		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * 获取上一天.
	 *
	 * @param currentDate
	 *            the current date
	 * @return the next date str
	 * @throws ParseException
	 *             the parse exception
	 */
	public static String getYesterdayStr(String currentDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date date = sdf.parse(currentDate);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, -1);
		String nextDate = sdf.format(calendar.getTime());
		return nextDate;
	}

	/**
	 * 根据日期获取星期
	 *
	 * @param strdate
	 * @return
	 */
	public static String getWeekDayByDate(String strdate) {
		final String dayNames[] = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		SimpleDateFormat sdfInput = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		Date date = new Date();
		try {
			date = sdfInput.parse(strdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		calendar.setTime(date);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		if (dayOfWeek < 0)
			dayOfWeek = 0;
		return dayNames[dayOfWeek];
	}

	/**
	 * 生成固定长度的随机字符和数字
	 *
	 * @param len
	 * @return
	 */
	public static String generateRandomCharAndNumber(Integer len) {
		StringBuffer sb = new StringBuffer();
		for (Integer i = 0; i < len; i++) {
			int intRand = (int) (Math.random() * 52);
			int numValue = (int) (Math.random() * 10);
			char base = (intRand < 26) ? 'A' : 'a';
			char c = (char) (base + intRand % 26);
			if (numValue % 2 == 0) {
				sb.append(c);
			} else {
				sb.append(numValue);
			}
		}
		return sb.toString();
	}

	public static String readPropertiesFile(String key) {
		String fileName = "/filepath_win.properties";
		String filePath = "";
		InputStream inputStream = StringUtils.class.getResourceAsStream(fileName);
		Properties pros = new Properties();
		try {
			pros.load(inputStream);
			filePath = pros.getProperty(key);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return filePath;
	}

	/**
	 * 方法描述：将系统限定的路径转换为绝对正确的路径
	 *
	 * @param originalPath
	 * @return
	 */
	public static String getGeneralFilePath(String originalPath) {
		if ((null != originalPath) && !("".equals(originalPath))) {
			String strPath[] = originalPath.split("\\\\|/");
			originalPath = "";
			// 拼接jar路径
			for (int i = 0; i < strPath.length; i++) {
				if (!("".equals(strPath[i])) && !("".equals(strPath[i].trim()))) {
					originalPath = originalPath + strPath[i].trim();
					if (i < strPath.length - 1) {
						originalPath = originalPath + File.separator;
					}
				}
			}
		}
		return originalPath;
	}

	/**
	 * 往文件写数据
	 */
	public static void WriteFile(String content, String filePath, String fileName) throws IOException {

		File file = new File(filePath);
		if (!file.exists()) {
			file.mkdirs();
		}
		File f1 = new File(filePath + File.separator + fileName);
		FileUtils.writeStringToFile(f1, content, "utf-8");
		// try {
		//
		// FileOutputStream fos = new FileOutputStream(f1);
		// fos.write(content.getBytes());
		// fos.close();
		//
		// } catch (IOException e) {
		// System.out.println("Uh oh, got an IOException error!");
		// e.printStackTrace();
		// }
	}

	/**
	 * 复制文件(以超快的速度复制文件)
	 *
	 * @param srcFile
	 *            源文件File
	 * @param
	 * @param
	 * @return 实际复制的字节数，如果文件、目录不存在、文件为null或者发生IO异常，返回-1
	 */
	@SuppressWarnings("resource")
	public static long copyFile(File srcFile, File destFile) throws Exception {
		long copySizes = 0;
		FileChannel fcin = new FileInputStream(srcFile).getChannel();
		FileChannel fcout = new FileOutputStream(destFile).getChannel();
		long size = fcin.size();
		fcin.transferTo(0, fcin.size(), fcout);
		fcin.close();
		fcout.close();
		copySizes = size;
		return copySizes;
	}

	/**
	 * 删除单个文件
	 *
	 * @param fileName
	 *            被删除文件的文件名
	 * @return 单个文件删除成功返回true, 否则返回false
	 */
	public static boolean deleteFile(String fileName) {
		File file = new File(fileName);
		if (file.isFile() && file.exists()) {
			file.delete();
			System.out.println("删除单个文件" + fileName + "成功！");
			return true;
		} else {
			System.out.println("删除单个文件" + fileName + "失败！");
			return false;
		}
	}

	/**
	 * @param count
	 *            位数，如果是1就产生1位的数字，如果是2就产生2位数字，依次类推
	 * @return
	 * @Title: getRandomNumber
	 * @Description: 获取随机数
	 */
	public static String getRandomNumber(int count) {
		String result = "";
		for (int i = 0; i < count; i++) {
			int rand = (int) (Math.random() * 10);
			result += rand;
		}
		return result;
	}

	public static void makeDir(File dir) {
		if (!dir.getParentFile().exists()) {
			makeDir(dir.getParentFile());
		}
		dir.mkdir();
	}
	
	/**
	 * @param date
	 * @param formatStr 格式化模板，如"yyyy-MM-dd HH:mm:ss"
	 * @return
	 * @author:     huxiebing 749450931@qq.com
	 * @Description: 将时间字符串格式化成一个日期(java.util.Date)
	 */
	public static String formatDate2String(Date date, String formatStr) {
        DateFormat dateFormat = new SimpleDateFormat(formatStr);
        String result = null;
        try {
            result = dateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

	/**
     * 数据格式化.
     *
     * @param pattern the pattern
     * @param
     * @return the string
     */
    public static String codeFormat(String pattern, Object value) {
        DecimalFormat df = new DecimalFormat(pattern);
        return df.format(value);
    }
}
