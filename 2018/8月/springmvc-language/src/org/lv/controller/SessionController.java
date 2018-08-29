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
			//�������Ļ���
			if(request_locale.equals("zh_CN")) {
				Locale locale = new Locale("zh","CN");
				request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, locale);
			}
			else if(request_locale.equals("en_US")) {
				//����Ӣ�Ļ���
				Locale locale = new Locale("en","US");
				request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, locale);
			}
			else {
				//ʹ��֮ǰ�����Ի���
				request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,
						LocaleContextHolder.getLocale());
			}
		}
		User user = new User();
		model.addAttribute("user",user);
		//��̬��תҳ��
		return "SessionLoginForm";
	}
	
	@RequestMapping(value="/login1",method=RequestMethod.POST)
	public String login(
			@ModelAttribute @Validated User user,
			Model model,
			HttpServletRequest request) {
		//�����¼����loooody��������520������֤ͨ��
		System.out.println("��login");
		if(user.getLoginname() != null && user.getLoginname().equals("loooody")
				&& user.getPassword() != null && user.getPassword().equals("520")) {
			//�Ӻ�̨�����ȡ���ʻ���Ϣusrname
			RequestContext requestContext = new RequestContext(request);
			String username = requestContext.getMessage("username");
			//����ȡ����username��Ϣ���õ�User���󣬲����õ�Model��
			user.setLoginname(username);
			model.addAttribute("user",user);
			return "success";
		}
		return "error";
	}
}
