package com.bestway.program.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 
 * 说明：配置数据源
 * 
 * @author J.
 * @version 1.0
 * @date 2017年6月29日
 */
@Configuration
public class DruidConfiguration {

	/**
	 * 
	 * 说明：添加druidServlet
	 * 
	 * @author J.
	 * @return
	 * @time：2017年6月29日 下午2:39:23
	 */
	@Bean
	public ServletRegistrationBean druidServlet() {
		return new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
	}

	/**
	 * 
	 * 说明：配置DataSource
	 * 
	 * @author J.
	 * @param driver
	 * @param url
	 * @param username
	 * @param password
	 * @param initialSize
	 * @param maxActive
	 * @param minIdle
	 * @param maxWait
	 * @return
	 * @time：2017年6月29日 下午2:38:40
	 */
	@Primary
	@Bean(name = "druidDataSource")
	public DataSource druidDataSource(@Value("${spring.datasource.druid.driverClassName}") String driver, @Value("${spring.datasource.druid.url}") String url, @Value("${spring.datasource.druid.username}") String username, @Value("${spring.datasource.druid.password}") String password, @Value("${spring.datasource.druid.initialSize}") int initialSize,
                                      @Value("${spring.datasource.druid.maxActive}") int maxActive, @Value("${spring.datasource.druid.minIdle}") int minIdle, @Value("${spring.datasource.druid.maxWait}") int maxWait) {
		DruidDataSource druidDataSource = new DruidDataSource();
		druidDataSource.setDriverClassName(driver);
		druidDataSource.setUrl(url);
		druidDataSource.setUsername(username);
		druidDataSource.setPassword(password);
		druidDataSource.setMinIdle(minIdle);
		druidDataSource.setInitialSize(initialSize);
		druidDataSource.setMaxActive(maxActive);
		druidDataSource.setMaxWait(maxWait);
		return druidDataSource;
	}

	/**
	 * 
	 * 说明：取消过滤url
	 * 
	 * @author J.
	 * @return
	 * @time：2017年6月29日 下午2:38:23
	 */
	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new WebStatFilter());
		filterRegistrationBean.addUrlPatterns("/*");
		filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
		return filterRegistrationBean;
	}
}
