package com.bestway.program.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * 说明：swagger 配置
 * 
 * @author J.
 * @version 1.0
 * @date 2017年6月29日
 */
@Configuration
@EnableSwagger2
public class SwaggerConifgurantion {

	// private static final String BASE_PACKAGE = "com.bestway.program";

	@Bean
	public Docket createRestApi() {
		// Predicate<RequestHandler> predicate = new Predicate<RequestHandler>() {
		// public boolean apply(RequestHandler input) {
		// Class<?> declaringClass = input.declaringClass();
		// if (declaringClass == BasicErrorController.class)// 排除
		// return false;
		// if (declaringClass.isAnnotationPresent(RestController.class)) // 被注解的类
		// return true;
		// if (input.isAnnotatedWith(ResponseBody.class)) // 被注解的方法
		// return true;
		// return true;
		// }
		//
		// };
		// return new
		// Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(predicate).paths(PathSelectors.any()).build();
		return new Docket(DocumentationType.SWAGGER_2).groupName("program").apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.bestway.program")).paths(PathSelectors.any()).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("百纬健康管理系统").version("1.0").build();
	}
}
