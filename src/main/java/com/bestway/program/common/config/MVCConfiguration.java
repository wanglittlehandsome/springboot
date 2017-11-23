package com.bestway.program.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.nio.charset.Charset;
import java.util.List;

/**
 * 
 * 说明：SpringMVC配置
 * 
 * @author J.
 * @version 1.0
 * @date 2017年6月29日
 */
@Configuration
public class MVCConfiguration extends WebMvcConfigurerAdapter {

	/**
	 * 设置拦截的请求 多个拦截器组成一个拦截器链 addPathPatterns-用于添加拦截规则 excludePathPatterns-用于排除拦截
	 */
	public void addInterceptors(InterceptorRegistry registry) {
		// registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")
		// .excludePathPatterns("/login/login", "/swagger-ui.html#", "/swagger-resources/**", "api-docs");
		// super.addInterceptors(registry);
	}

	/**
	 * 设置编码
	 */
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
		converters.add(new MappingJackson2HttpMessageConverter());
	}

}
