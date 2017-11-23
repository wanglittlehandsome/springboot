package com.bestway.program.common.ehcache;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * 
 * 说明：mybatis缓存配置.
 * 
 * @author J.
 * @version 1.0
 * @date 2017年6月29日
 */
@Configuration
@EnableCaching
// 标注启动缓存
public class CacheConfiguration {

	/**
	 * 
	 * 说明：ehcache 主要的管理器
	 * 
	 * @author J.
	 * @param bean
	 * @return
	 * @time：2017年6月29日 下午3:57:53
	 */
	@Bean("cacheManager")
	public EhCacheCacheManager ehCacheCacheManager(EhCacheManagerFactoryBean bean) {
		System.out.println("CacheConfiguration.ehCacheCacheManager()");
		return new EhCacheCacheManager(bean.getObject());
	}

	/**
	 * 据shared与否的设置, Spring分别通过CacheManager.create() 或new CacheManager()方式来创建一个ehcache基地. 也说是说通过这个来设置cache的基地是这里的Spring独用, 还是跟别的(如hibernate的Ehcache共享)
	 */
	@Bean
	public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
		System.out.println("CacheConfiguration.ehCacheManagerFactoryBean()");
		EhCacheManagerFactoryBean cacheManagerFactoryBean = new EhCacheManagerFactoryBean();
		cacheManagerFactoryBean.setConfigLocation(new ClassPathResource("/ehcache.xml"));
		cacheManagerFactoryBean.setShared(true);
		return cacheManagerFactoryBean;
	}
}
