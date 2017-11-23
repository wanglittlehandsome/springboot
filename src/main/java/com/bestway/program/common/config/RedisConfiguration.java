package com.bestway.program.common.config;

import com.bestway.program.common.exception.RedisConfigException;
import com.bestway.program.common.utils.LogUtils;
import com.bestway.program.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 说明：Redis配置文件
 * 
 * @author J.
 * @version 1.0
 * @date 2017年8月18日
 */
@Configuration
public class RedisConfiguration {

	private static final Logger logger = LoggerFactory.getLogger(RedisConfiguration.class);

	@Autowired
	private Environment env;

	private static final String REDIS_PROPERTY_PREFIX = "spring.redis.shard.";

	@Bean
	@ConfigurationProperties(prefix = "spring.redis.pool")
	public JedisPoolConfig getJedisPoolConfig() {
		return new JedisPoolConfig();
	}

	@Bean
	public ShardedJedisPool getJedisPool() {
		try {
			List<JedisShardInfo> shardList = new ArrayList<>();
			int index = 1;
			while (true) {
				// 读取host
				String host = env.getProperty(REDIS_PROPERTY_PREFIX + index + ".host");
				if (StringUtils.isEmpty(host)) {
					break;
				}
				// 读取port
				String port = env.getProperty(REDIS_PROPERTY_PREFIX + index + ".port");
				JedisShardInfo info = new JedisShardInfo(host, Integer.valueOf(port), 0, "");
				// 读取password
				String password = env.getProperty(REDIS_PROPERTY_PREFIX + index + ".password");
				if (!StringUtils.isEmpty(password)) {
					info.setPassword(password);
				}
				shardList.add(info);
				index++;
			}
			if (shardList.isEmpty()) {
				// 无法加载redis
				throw new IOException();
			}
			return new ShardedJedisPool(getJedisPoolConfig(), shardList);
		} catch (Exception e) {
			logger.error(LogUtils.getExceptionInfo(e));
			throw new RedisConfigException("无法加载资源文件!");
		}
	}

}
