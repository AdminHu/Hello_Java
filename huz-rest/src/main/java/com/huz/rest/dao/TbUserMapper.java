package com.huz.rest.dao;

import java.util.List;

import com.huz.rest.pojo.TbUser;

public interface TbUserMapper {
	List<TbUser> queryForList();
	List<TbUser> queryById(Long id);
}