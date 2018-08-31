package org.lv.service.impl;

import org.lv.domain.User;
import org.lv.mapper.UserMapper;
import org.lv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
	/**
	 * �Զ�ע��UserMapper
	 */
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * UserService�ӿ�login����ʵ��
	 */
	public User login(String loginname,String password) {
		return userMapper.findWithLoginnameAndPassword(loginname, password);
	}
}
