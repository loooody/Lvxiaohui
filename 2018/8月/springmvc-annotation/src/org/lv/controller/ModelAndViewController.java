package org.lv.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lv.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ModelAndViewController {

	private static final Log logger = LogFactory.getLog(ModelAndViewController.class);
	
	@ModelAttribute
	public void userModel(String name,String password,ModelAndView mv) {
		logger.info("usermodel");
		User user = new User();
		user.setUsername(name);
		user.setPassword(password);
		//将User对象添加到ModelAndView的model中
		mv.addObject("user",user);
	}
	
	@RequestMapping(value="/userLogin")
	public ModelAndView userLogin(ModelAndView mv) {
		logger.info("userLogin");
		//从ModelAndView的Model当中取出之前存入的名为user的对象
		User user = (User) mv.getModel().get("user");
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		//设置user对象的username属性
		user.setUsername("测试");
		//设置返回的视图名称
		mv.setViewName("login");
		return mv;
	}
}
