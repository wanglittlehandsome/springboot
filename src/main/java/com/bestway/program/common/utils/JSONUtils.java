package com.bestway.program.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * 
 * 说明：JSON工具类
 * 
 * @author J.
 * @version 1.0
 * @date 2017年7月3日
 */
public class JSONUtils {

	private JSONUtils() {
		throw new IllegalAccessError("Utility class");
	}

	/**
	 * 
	 * 说明：对象转JSON字符串
	 * 
	 * @author J.
	 * @param obj
	 * @return
	 * @time：2017年7月3日 下午2:49:49
	 */
	public static <T> String toJSONString(T obj) {
		return JSON.toJSONString(obj, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullListAsEmpty,
				SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullBooleanAsFalse);
	}

	/**
	 * 
	 * 说明：JSON字符串转JAVA对象
	 * 
	 * @author J.
	 * @param str
	 * @param cls
	 * @return
	 * @time：2017年7月3日 下午2:50:23
	 */
	public static <T> T parseToObject(String str, Class<T> cls) {
		JSON json = JSON.parseObject(str);
		if (json == null) {
			return null;
		}
		return JSON.toJavaObject(json, cls);
	}

	/**
	 * 
	 * 说明：JSON字符串转List集合
	 * 
	 * @author J.
	 * @param str
	 * @param cls
	 * @return
	 * @time：2017年7月3日 下午2:51:01
	 */
	public static <T> List<T> parseToList(String str, Class<T> cls) {
		JSONArray jsonArr = JSON.parseArray(str);
		if (jsonArr == null) {
			return Lists.newArrayList();
		}

		List<T> resultList = Lists.newArrayList();

		for (int i = 0; i < jsonArr.size(); i++) {
			resultList.add(JSON.toJavaObject(jsonArr.getJSONObject(i), cls));
		}
		return resultList;
	}

}
