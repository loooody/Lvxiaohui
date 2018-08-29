package org.lv.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lv.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController{
	private static final Log logger = LogFactory.getLog(UserController.class);
	
	@RequestMapping(value="{formName}")
	public String loginForm(@PathVariable String formName) {
		//��̬ת��ҳ��
		return formName;
	}
	/**
	 * ����/login��¼
	 */
	@RequestMapping(value="/login")
	public ModelAndView login(
			String loginname,String password,
			ModelAndView mv,
			HttpSession session) {
		//ģ�����ݿ���ݵ�¼������������û����ж��û���¼
		if(loginname != null && loginname.equals("loooody")
				&& password != null && password.equals("123")) {
			//ģ�ⴴ���û�
			User user = new User();
			user.setLoginname(loginname);
			user.setPassword(password);
			user.setUsername("����Ա");
			//��¼�ɹ��أ���user�������õ�HttpSession������
			session.setAttribute("user", user);
			//ת����main����
			mv.setViewName("redirect:main");
		}else {
			//��¼ʧ�ܣ�����ʧ����ʾ��Ϣ������ת����¼ҳ��
			mv.addObject("message","��¼���������������������");
			mv.setViewName("loginForm");
		}
		return mv;
	}
	
}
