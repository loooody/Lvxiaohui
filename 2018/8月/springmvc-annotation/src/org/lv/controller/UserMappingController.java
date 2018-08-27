package org.lv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/user")
public class UserMappingController {
	
	@RequestMapping("/register")
	public String register() {
		System.out.println("进入这里");
		return "register";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
}
