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
		User user = new User("jack","��",28);
		//model���������command��ֵ��user����
		model.addAttribute("command",user);
		return "registerForm";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String register(Model model) {
		User user = new User("loooody","��",21);
		//model��������ԣ�ֵ��user����
		model.addAttribute("user",user);
		return "register";
	}
}
