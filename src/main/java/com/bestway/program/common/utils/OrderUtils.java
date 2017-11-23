package com.bestway.program.common.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @ClassName OrderUtils
 * @author huxiebing 749450931@qq.com
 * @Date 2017年9月4日 下午4:53:55
 * @version 1.0.0
 * @Description: 订单生成工具
 */
public class OrderUtils {
    
    /**
     * @return
     * @author:     huxiebing 749450931@qq.com
     * @Description: 生成交易号
     */
    public static String getToDayStrAsFileName() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return sdf.format(new Date());
    }
    
    /**
     * @return
     * @author:     huxiebing 749450931@qq.com
     * @Description: 生成订单编号
     */
    public static  String createOrderNumber(String number) {
        String result = "";
        //查询最大的订单号
        String numbers="";
//        String number = orderDao.selectMaxOrderNumber();
        if (number!=null) {
            numbers = number;
        }
        String thisYYMMDD = StringUtils.formatDate2String(new Date(), "yyMMdd");
        String stuff = "D" + thisYYMMDD; // 订单前缀
        if (StringUtils.isEmpty(numbers)) {
            result = stuff + "00001";
        } else {
            if (numbers.startsWith(stuff)) {
                String _earlyCount = numbers
                        .substring(thisYYMMDD.length() + 1);
                Integer earlyCount = Integer.valueOf(_earlyCount);
                String temp = String.valueOf(earlyCount + 1);
                int tempLength = temp.length();
                if (tempLength < 5) {
                    String zero = "";
                    for (int i = 0; i < (5 - tempLength); i++) {
                        zero += "0";
                    }
                    result = stuff + zero + String.valueOf(earlyCount + 1);
                } else {
                    result = stuff + String.valueOf(earlyCount + 1);
                }
            } else {
                result = stuff + "00001";
            }
        }
        return result;
    }
    
    
    /**
	 * 获取字符串的MD5表示
	 * @param convertStr
	 * @return MD5编码后的字符串，小写
	 */
	public static String getMD5String(String convertStr){
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("MD5");
		}
		catch (NoSuchAlgorithmException e) {
			throw new IllegalStateException("MD5 algorithm not available.  Fatal (should be in the JDK).");
		}

		try {
			byte[] bytes = digest.digest(convertStr.toString().getBytes("UTF-8"));
			return String.format("%032x", new BigInteger(1, bytes));
		}
		catch (UnsupportedEncodingException e) {
			throw new IllegalStateException("UTF-8 encoding not available.  Fatal (should be in the JDK).");
		}
	}

}
