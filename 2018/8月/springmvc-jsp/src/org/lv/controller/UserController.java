package org.lv.controller;

import org.lv.domain.User;
import org.lv.validator.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	
	@RequestMapping(value="/registerForm",method=RequestMethod.GET)
	public String registerForm(Model model) {
		User user = new User();
		//model中添加属性command，值是user对象
		model.addAttribute("user",user);
		return "registerForm";
	}
	/*
	@RequestMapping(value="/registerForm",method=RequestMethod.GET)
	public String registerForm(Model model) {
		User user = new User("jack","男",28);
		//model中添加属性command，值是user对象
		model.addAttribute("command",user);
		return "registerForm";
	}
	
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String register(Model model) {
		User user = new User("loooody","男",21,"520");
		//model中添加属性，值是user对象
		model.addAttribute("user",user);
		return "register";
	}
	*/
	
	@InitBinder
	public void initBinder(DataBinder binder) {
		//设置验证的类为UserValidator
		binder.setValidator(new UserValidator());
	}
	
	@RequestMapping(value="/register1",method=RequestMethod.POST)
	public String register1(@Validated User user,Errors errors) {
		//如果Error对象有filed错误时，重新跳回注册页面，否则正常提交
		if(errors.hasFieldErrors())
			return "registerForm";
		return "submit";
	}
}
