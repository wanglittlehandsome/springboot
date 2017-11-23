package com.bestway.program.common.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 
 * 说明：跨域处理
 * 
 * @author J.
 * @version 1.0
 * @date 2017年6月29日
 */
@Component
public class CorsFilter implements Filter {

	private static Logger logger = LoggerFactory.getLogger(CorsFilter.class);

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException,
            ServletException {
		HttpServletResponse response = (HttpServletResponse) res;
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS,DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with,token,Content-Type");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("token", "*");
		// System.out.println("***********************************过滤器被使用****** ********************");
		chain.doFilter(req, res);
	}

	@Override
	public void destroy() {
		logger.debug("应用程序关闭...");
	}

	// @Override
	public void init(FilterConfig config) throws ServletException {
		logger.debug("应用程序启动...");

		try {
			// factory.createTask(ScheduleNoticeJob.class);
			// factory.createTask(EasterEggsJob.class);
			// factory.createTask(AssignmentJob.class);
			// factory.start();
		} catch (Exception e) {
			logger.error(e.getMessage());
			// throw new SchedulerConfigException("定时任务初始化错误..请检查信息");
		}
	}
}
