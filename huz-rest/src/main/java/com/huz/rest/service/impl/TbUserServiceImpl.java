package com.huz.rest.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huz.common.utils.JsonUtils;
import com.huz.rest.dao.JedisClient;
import com.huz.rest.dao.TbUserMapper;
import com.huz.rest.pojo.TbUser;
import com.huz.rest.service.TbUserService;

@Service
@Transactional
public class TbUserServiceImpl implements TbUserService{

	@Autowired
	private TbUserMapper tbUserMapper;
	
	@Autowired
	private JedisClient jedisClient;
	
	@Value("${INDEX_CONTENT_REDIS_KEY}")
	private String INDEX_CONTENT_REDIS_KEY;
	
	@Override
	public List<TbUser> queryForList() {
		return tbUserMapper.queryForList();
	}

	@Override
	public List<TbUser> queryById(Long id) {
		/*String result = jedisClient.hget(INDEX_CONTENT_REDIS_KEY, id + "");
		if (!StringUtils.isBlank(result)) {
			//把字符串转换成list
			List<TbUser> resultList = JsonUtils.jsonToList(result, TbUser.class);
			return resultList;
		}*/
		List<TbUser> list = tbUserMapper.queryById(id);
		//向缓存中添加内容
		/*try {
			//把list转换成字符串
			String cacheString = JsonUtils.objectToJson(list);
			jedisClient.hset(INDEX_CONTENT_REDIS_KEY, id + "", cacheString);
			} catch (Exception e) {
				e.printStackTrace();
			}*/
		return list;
	}
}
