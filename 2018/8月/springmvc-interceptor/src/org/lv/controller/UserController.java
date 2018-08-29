package org.lv.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lv.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController{
	private static final Log logger = LogFactory.getLog(UserController.class);
	
	@RequestMapping(value="{formName}")
	public String loginForm(@PathVariable String formName) {
		//动态转跳页面
		return formName;
	}
	/**
	 * 处理/login登录
	 */
	@RequestMapping(value="/login")
	public ModelAndView login(
			String loginname,String password,
			ModelAndView mv,
			HttpSession session) {
		//模拟数据库根据登录名和密码查找用户，判断用户登录
		if(loginname != null && loginname.equals("loooody")
				&& password != null && password.equals("123")) {
			//模拟创建用户
			User user = new User();
			user.setLoginname(loginname);
			user.setPassword(password);
			user.setUsername("管理员");
			//登录成功呢，将user对象设置到HttpSession作用域
			session.setAttribute("user", user);
			//转发到main请求
			mv.setViewName("redirect:main");
		}else {
			//登录失败，设置失败提示信息，并跳转到登录页面
			mv.addObject("message","登录名或密码错误，请重新输入");
			mv.setViewName("loginForm");
		}
		return mv;
	}
	
}
