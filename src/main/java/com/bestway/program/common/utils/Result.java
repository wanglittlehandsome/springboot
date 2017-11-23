package com.bestway.program.common.utils;


/**
 * 说明：返回结果帮助类
 *
 * @author J.
 * @version 1.0
 * @date 2017年7月3日
 */
public class Result {

    private Result() {
        throw new IllegalAccessError("Utility class");
    }

    /**
     * 说明：将返回结果转化成json字符串
     *
     * @param obj
     * @return
     * @author J.
     * @time：2017年7月3日 下午2:47:03
     */
    public static String toJSON(Object obj) {
        return JSONUtils.toJSONString(obj);
    }

}
