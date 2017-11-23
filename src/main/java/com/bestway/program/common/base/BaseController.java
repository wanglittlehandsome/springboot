package com.bestway.program.common.base;

import com.bestway.program.common.redis.Redis;
import com.bestway.program.common.utils.JSONUtils;
import com.bestway.program.common.utils.StringUtils;
import com.bestway.program.model.pojo.user.LoginInfo;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * 说明：controller 父类
 * 
 * @author J.
 * @version 1.0
 * @date 2017年7月3日
 */
public class BaseController {

	// 异常信息返回
	protected static final String ERROR_MSG = "系统错误";
	// 成功返回信息
	protected static final String SUCCESS_MSG = "操作成功";

	// 操作成功Code
	protected static final int SUCCESS_CODE = 200;
	// 操作警告Code
	protected static final int WARN_CODE = 201;
	// 操作失败Code
	protected static final int ERROR_CODE = 500;
	// 校验错误
	protected static final int CHECK_CODE = 800;

	@Autowired
	private Redis redis;

	/**
	 * 
	 * 说明：获取当前登录用户ID
	 * 
	 * @author J.
	 * @return
	 * @time：2017年8月7日 上午10:12:19
	 */
	protected Long getUserId(String key) {
		return getCurrentLoginInfo(key).getUserId();
	}

	/**
	 * 
	 * 说明：获取当前用户登录信息
	 * 
	 * @author J.
	 * @return
	 * @time：2017年9月11日 下午3:30:38
	 */
	protected LoginInfo getCurrentLoginInfo(String key) {
		LoginInfo info = JSONUtils.parseToObject(redis.getObjectJosn(key),
				LoginInfo.class);
		return info;
	}

	/**
	 * 
	 * 说明：判断token
	 * 
	 * @author J.
	 * @return
	 * @time：2017年8月7日 上午10:12:19
	 */
	protected boolean isExist(String key) {
		if (StringUtils.isEmpty(key)) {
			return true;
		} else {
			if (!redis.isExist(key)) {
				return true;
			}
		}
		return false;
	}

}
