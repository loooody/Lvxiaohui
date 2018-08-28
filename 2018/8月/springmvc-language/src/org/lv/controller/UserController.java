package org.lv.controller;

import javax.servlet.http.HttpServletRequest;

import org.lv.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.RequestContext;

@Controller
public class UserController{
	
	@RequestMapping(value="/{formName}")
	public String loginForm(
			@PathVariable String formName,
			Model model) {
		User user = new User();
		model.addAttribute("user",user);
		//动态转跳页面
		return formName;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(
			@ModelAttribute @Validated User user,
			Model model,
			HttpServletRequest request) {
		//如果登录名是loooody，密码是520，则验证通过
		if(user.getLoginname() != null && user.getLoginname().equals("loooody")
				&& user.getPassword() != null && user.getPassword().equals("520")) {
			//从后台代码获取国际化信息usrname
			RequestContext requestContext = new RequestContext(request);
			String username = requestContext.getMessage("username");
			//将获取到的username信息设置到User对象，并设置到Model中
			user.setLoginname(username);
			model.addAttribute("user",user);
			return "success";
		}
		return "error";
	}
	
}
