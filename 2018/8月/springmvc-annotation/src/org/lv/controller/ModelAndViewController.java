package org.lv.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lv.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ModelAndViewController {

	private static final Log logger = LogFactory.getLog(ModelAndViewController.class);
	
	@ModelAttribute
	public void userModel(String name,String password,ModelAndView mv) {
		logger.info("usermodel");
		User user = new User();
		user.setUsername(name);
		user.setPassword(password);
		//��User������ӵ�ModelAndView��model��
		mv.addObject("user",user);
	}
	
	@RequestMapping(value="/userLogin")
	public ModelAndView userLogin(ModelAndView mv) {
		logger.info("userLogin");
		//��ModelAndView��Model����ȡ��֮ǰ�������Ϊuser�Ķ���
		User user = (User) mv.getModel().get("user");
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		//����user�����username����
		user.setUsername("����");
		//���÷��ص���ͼ����
		mv.setViewName("login");
		return mv;
	}
}
