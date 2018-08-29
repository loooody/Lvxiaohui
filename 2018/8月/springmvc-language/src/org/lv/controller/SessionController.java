package org.lv.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.lv.domain.User;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.support.RequestContext;

@Controller
public class SessionController {
	
	@RequestMapping(value="/SessionLoginForm")
	public String SessionLoginForm(
			String request_locale,
			Model model,
			HttpServletRequest request) {
		System.out.println("request_locale = " + request_locale);
		if(request_locale != null) {
			//设置中文环境
			if(request_locale.equals("zh_CN")) {
				Locale locale = new Locale("zh","CN");
				request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, locale);
			}
			else if(request_locale.equals("en_US")) {
				//设置英文环境
				Locale locale = new Locale("en","US");
				request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, locale);
			}
			else {
				//使用之前的语言环境
				request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,
						LocaleContextHolder.getLocale());
			}
		}
		User user = new User();
		model.addAttribute("user",user);
		//动态跳转页面
		return "SessionLoginForm";
	}
	
	@RequestMapping(value="/login1",method=RequestMethod.POST)
	public String login(
			@ModelAttribute @Validated User user,
			Model model,
			HttpServletRequest request) {
		//如果登录名是loooody，密码是520，则验证通过
		System.out.println("到login");
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
