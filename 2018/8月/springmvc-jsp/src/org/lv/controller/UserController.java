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
		//model���������command��ֵ��user����
		model.addAttribute("user",user);
		return "registerForm";
	}
	/*
	@RequestMapping(value="/registerForm",method=RequestMethod.GET)
	public String registerForm(Model model) {
		User user = new User("jack","��",28);
		//model���������command��ֵ��user����
		model.addAttribute("command",user);
		return "registerForm";
	}
	
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String register(Model model) {
		User user = new User("loooody","��",21,"520");
		//model��������ԣ�ֵ��user����
		model.addAttribute("user",user);
		return "register";
	}
	*/
	
	@InitBinder
	public void initBinder(DataBinder binder) {
		//������֤����ΪUserValidator
		binder.setValidator(new UserValidator());
	}
	
	@RequestMapping(value="/register1",method=RequestMethod.POST)
	public String register1(@Validated User user,Errors errors) {
		//���Error������filed����ʱ����������ע��ҳ�棬���������ύ
		if(errors.hasFieldErrors())
			return "registerForm";
		return "submit";
	}
}
