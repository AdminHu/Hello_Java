package com.huz.rest.service;

import java.util.List;

import com.huz.rest.pojo.TbUser;

public interface TbUserService {
	List<TbUser> queryForList();
	List<TbUser> queryById(Long id);
}
