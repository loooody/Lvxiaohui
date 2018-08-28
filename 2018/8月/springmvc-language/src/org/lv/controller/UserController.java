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
		//��̬ת��ҳ��
		return formName;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(
			@ModelAttribute @Validated User user,
			Model model,
			HttpServletRequest request) {
		//�����¼����loooody��������520������֤ͨ��
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
