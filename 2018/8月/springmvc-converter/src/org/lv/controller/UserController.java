package org.lv.controller;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lv.converter.DateEditor;
import org.lv.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController{
	private static final Log logger = LogFactory.getLog(UserController.class);
	
	@RequestMapping(value="/{formName}")
	public String loginForm(@PathVariable String formName) {
		//动态转跳页面
		return formName;
	}
	
	@RequestMapping(value="register",method=RequestMethod.POST)
	public String register(@ModelAttribute User user,Model model) {
		logger.info(user);
		model.addAttribute("user",user);
		return "success";
	}
	
	//在控制器初始化时注册属性编辑器
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		//注册自定义编辑器
		binder.registerCustomEditor(Date.class, new DateEditor());
	}
}
