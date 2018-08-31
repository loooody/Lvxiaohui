package org.lv.service;

import org.lv.domain.User;

public interface UserService {
	/**
	 * 判断用户登录
	 * 找到返回User对象，没有找到返回null
	 */
	User login(String loginname,String password);
	
}
