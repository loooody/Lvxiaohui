package org.lv.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * HelloController��һ������ע��Ŀ�����
 * ����ͬʱ����������������������ʵ������ӿ�
 * @author 319667916
 *
 */
@Controller
public class HelloController{
	
	private static final Log logger = LogFactory.getLog(HelloController.class);

	@RequestMapping(value="/hello")
	public ModelAndView hello() {
		logger.info("hello����������");
		//����׼�����ص�ModelAndView����
		ModelAndView mv = new ModelAndView();
		//���ģ������
		mv.addObject("message","hello !!!");
		//������ͼ��
		mv.setViewName("WEB-INF/content/welcome.jsp");
		return mv;
	}
	
	
}
