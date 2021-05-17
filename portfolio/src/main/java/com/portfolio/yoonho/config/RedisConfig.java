package com.portfolio.yoonho.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/*
 * 	- Redis 연동을 위한 라이브러리로 Jedis, Lettuce 등 존재. (Lettuce 사용)
 *  - Lettuce 사용이유
 *   (1) Jedis는 약 3년동안 업데이트x
 *   (2) Jedis는 Thread safe하지 않음 (Jedis Pool을 사용하여 Thread safe하게 할 수 있지만 인스턴스를 미리 만들어 대기하므로 비용이 증가되는 단점 존재)
 *   (3) Lettuce는 Thread간 자원 공유 가능
 *   (4) Spring boot 2.0 부터 Jedis는 deprecated됨.
 *  
 */

@Configuration
public class RedisConfig {
	
	@Bean
	public RedisConnectionFactory redisConnectionFactory() {
		LettuceConnectionFactory cf = new LettuceConnectionFactory();
		return cf;
	}
	
	@Bean
	public RedisTemplate<String, Object> redisTemplate(){
		RedisTemplate<String, Object> rt = new RedisTemplate<String, Object>();
		rt.setConnectionFactory(redisConnectionFactory());
		rt.setKeySerializer(new StringRedisSerializer());
		rt.setValueSerializer(new StringRedisSerializer());
		
		return rt;
	}
}
