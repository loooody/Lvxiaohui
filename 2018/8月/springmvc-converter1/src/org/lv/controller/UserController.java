package org.lv.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lv.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController{
	private static final Log logger = LogFactory.getLog(UserController.class);
	
	@RequestMapping(value="/{formName}")
	public String loginForm(@PathVariable String formName) {
		//¶¯Ì¬Ìø×ªÒ³Ãæ
		return formName;
	}
	
	@RequestMapping(value="/test",method=RequestMethod.POST)
	public String register(@ModelAttribute User user,Model model) {
		logger.info(user);
		model.addAttribute("user",user);
		return "success";
	}
	
}
