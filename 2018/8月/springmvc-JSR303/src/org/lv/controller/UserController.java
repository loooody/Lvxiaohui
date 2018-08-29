package org.lv.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lv.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController{
	private static final Log logger = LogFactory.getLog(UserController.class);
	
	@RequestMapping(value="/{formName}")
	public String loginForm(@PathVariable String formName,Model model) {
		User user = new User();
		model.addAttribute("user",user);
		//��̬��תҳ��
		return formName;
	}
	
	//����У��ʹ��@Valid���������Error���󱣴�У����Ϣ
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(
			@Valid @ModelAttribute User user,
			Errors errors,
			Model model) {
		logger.info(user);
		if(errors.hasErrors()) {
			return "register";
		}
		model.addAttribute("user",user);
		return "success";
	}
	
}
