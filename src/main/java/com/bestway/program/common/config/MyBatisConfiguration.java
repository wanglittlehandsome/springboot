package com.bestway.program.common.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * 
 * 说明：MyBatis配置
 * 
 * @author J.
 * @version 1.0
 * @date 2017年6月29日
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.bestway.program.dao")
public class MyBatisConfiguration {

	/**
	 * 
	 * 说明：SQLSessionFactory配置
	 * 
	 * @author J.
	 * @param ds
	 * @return
	 * @throws Exception
	 * @time：2017年6月29日 下午2:41:50
	 */
	@Bean
	public SqlSessionFactory sqlSessionFactoryBean(@Qualifier("druidDataSource") DataSource ds) throws Exception {
		try {
			SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
			// 设置数据源
			sqlSessionFactoryBean.setDataSource(ds);
			// 设置查找器
			PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
			// 自动扫描mybatis文件
			sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mapper/*/*.xml"));
			return sqlSessionFactoryBean.getObject();
		} catch (Exception e) {
			throw new Exception("Mybatis初始化失败", e);
		}
	}
}
