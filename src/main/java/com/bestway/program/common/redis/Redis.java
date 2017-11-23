package com.bestway.program.common.redis;

import com.alibaba.fastjson.JSON;
import com.bestway.program.common.utils.LogUtils;
import com.bestway.program.common.utils.SerializeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.io.Serializable;

/**
 * 
 * 说明：redis操作类
 * 
 * @author J.
 * @version 1.0
 * @date 2017年9月7日
 */
@Component
public class Redis {

	private static Logger logger = LoggerFactory.getLogger(Redis.class);

	@Autowired
	private ShardedJedisPool shardedJedisPool;

	/**
	 * 
	 * 说明：保存对象(序列化)
	 * 
	 * @author J.
	 * @param key
	 * @param obj
	 * @param time
	 * @time：2017年9月7日 上午10:28:51
	 */
	public <T extends Serializable> void setObject(String key, T obj, int time) {
		try (ShardedJedis jedis = shardedJedisPool.getResource()) {
			jedis.set(key.getBytes(), SerializeUtils.serialize(obj));
			if (time > 0) {
				jedis.expire(key.getBytes(), time);
			}
			logger.info(String.format("redis setObject info:[key:%s,value:%s,outTime:%d]", key, obj.toString(), time));
		} catch (Exception e) {
			logger.error(LogUtils.getExceptionInfo(e));
		}
	}

	/**
	 * 
	 * 说明：保存对象(json)
	 * 
	 * @author J.
	 * @param key
	 * @param obj
	 * @param time
	 * @time：2017年8月18日 上午11:37:25
	 */
	public <T extends Serializable> void setObjectJosn(String key, T obj, int time) {

		try (ShardedJedis jedis = shardedJedisPool.getResource()) {
			jedis.set(key, JSON.toJSONString(obj));
			if (time > 0) {
				jedis.expire(key, time);
			}
			logger.info(String.format("redis setObject info:[key:%s,value:%s,outTime:%d]", key, obj.toString(), time));
		} catch (Exception e) {
			logger.error(LogUtils.getExceptionInfo(e));
		}
	}

	/**
	 * 
	 * 说明：保存对象无过期时间
	 * 
	 * @author J.
	 * @param key
	 * @param obj
	 * @time：2017年9月7日 上午10:29:02
	 */
	public <T extends Serializable> void setObject(String key, T obj) {
		setObject(key, obj, 0);
	}

	/**
	 * 
	 * 说明：取出对象(反序列化)
	 * 
	 * @author J.
	 * @param key
	 * @return
	 * @time：2017年9月7日 上午10:29:16
	 */
	@SuppressWarnings("unchecked")
	public <T> T getObject(String key) {
		T obj = null;
		try (ShardedJedis jedis = shardedJedisPool.getResource()) {
			byte[] data = jedis.get(key.getBytes());
			obj = (T) SerializeUtils.deserialize(data);

			logger.info(String.format("redis getObject info:[key:%s,value:%s]", key,
					obj == null ? "null" : obj.toString()));
		} catch (Exception e) {
			logger.error(LogUtils.getExceptionInfo(e));
		}
		return obj;
	}

	/**
	 * 
	 * 说明：获取对象(json)
	 * 
	 * @author J.
	 * @param key
	 * @return
	 * @time：2017年8月18日 上午11:41:26
	 */
	public String getObjectJosn(String key) {
		String s = null;
		try (ShardedJedis jedis = shardedJedisPool.getResource()) {
			s = jedis.get(key);
			logger.info(String.format("redis getObject info:[key:%s,value:%s]", key, s == null ? "null" : s.toString()));
		} catch (Exception e) {
			logger.error(LogUtils.getExceptionInfo(e));
		}
		return s;
	}

	/**
	 * 
	 * 说明：根据key删除对象
	 * 
	 * @author J.
	 * @param key
	 * @return
	 * @time：2017年9月7日 上午10:29:25
	 */
	public Long delete(String key) {
		Long temp = null;
		try (ShardedJedis jedis = shardedJedisPool.getResource()) {
			// temp = jedis.del(key.getBytes());
			temp = jedis.del(key);
			logger.info(String.format("redis deleteDate info:[key:%s]", key));
		} catch (Exception e) {
			logger.error(LogUtils.getExceptionInfo(e));
		}
		return temp;
	}

	/**
	 * 
	 * 说明：判断是否存在
	 * 
	 * @author J.
	 * @param key
	 * @return
	 * @time：2017年9月7日 上午10:29:39
	 */
	public boolean isExist(String key) {
		boolean flag = false;
		try (ShardedJedis jedis = shardedJedisPool.getResource()) {
			// flag = jedis.exists(key.getBytes());
			flag = jedis.exists(key);

			logger.info(String.format("redis isExist info:[key:%s]", key));
		} catch (Exception e) {
			logger.error(LogUtils.getExceptionInfo(e));
		}
		return flag;
	}

	/**
	 * 
	 * 说明：更新过期时间
	 * 
	 * @author J.
	 * @param key
	 * @param time
	 * @time：2017年9月7日 上午10:29:51
	 */
	public void updateTime(String key, int time) {
		try (ShardedJedis jedis = shardedJedisPool.getResource()) {
			// jedis.expire(key.getBytes(), time);
			jedis.expire(key, time);

			logger.info(String.format("redis updateTime info:[key:%s,time:%d]", key, time));
		} catch (Exception e) {
			logger.error(LogUtils.getExceptionInfo(e));
		}
	}

}
