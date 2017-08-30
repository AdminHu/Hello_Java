package com.huz.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.huz.common.pojo.HzResult;
import com.huz.common.utils.ExceptionUtil;
import com.huz.rest.dao.JedisClient;
import com.huz.rest.service.RedisService;

@Service
public class RedisServiceImpl implements RedisService {

	@Autowired
	private JedisClient jedisClient;
	
	@Value("${INDEX_CONTENT_REDIS_KEY}")
	private String INDEX_CONTENT_REDIS_KEY;
	
	@Override
	public HzResult testCache() {
		try {
			jedisClient.incr(INDEX_CONTENT_REDIS_KEY);
		} catch (Exception e) {
			e.printStackTrace();
			return HzResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		return HzResult.ok();
	}

}
