package org.lv.controller;

import org.lv.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	@RequestMapping(value="/registerForm",method=RequestMethod.GET)
	public String registerForm(Model model) {
		User user = new User("jack","男",28);
		//model中添加属性command，值是user对象
		model.addAttribute("command",user);
		return "registerForm";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String register(Model model) {
		User user = new User("loooody","男",21);
		//model中添加属性，值是user对象
		model.addAttribute("user",user);
		return "register";
	}
}
