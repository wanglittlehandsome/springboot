package com.bestway.program.common.interceptor;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 
 * 说明：拦截器
 * 
 * @author J.
 * @version 1.0
 * @date 2017年9月7日
 */
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

	// 排除不拦截的URL
	private static List<String> excludeURL = Lists.newArrayList();

	static {
		excludeURL.add("/program/v2/api-docs");

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		// 不需要过滤的接口 直接true
		String uri = request.getRequestURI();
		if (excludeURL.stream().filter(url -> url.equals(uri) || Pattern.compile(url).matcher(uri).find()).count() > 0) {
			return true;
		}

		// Object userObj = request.getSession().getAttribute("user");
		// if (userObj == null) {
		// BaseResult resultModule = new BaseResult();
		// resultModule.setMessage("登陆超时或未登陆，请先登陆后再进行操作");
		// response.getWriter().write(Result.toJSON(resultModule));
		// response.setStatus(401);
		// return false;
		// }
		return super.preHandle(request, response, handler);
	}
}
