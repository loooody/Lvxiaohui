package org.lv.service;

import org.lv.domain.User;

public interface UserService {
	/**
	 * �ж��û���¼
	 * �ҵ�����User����û���ҵ�����null
	 */
	User login(String loginname,String password);
	
}
