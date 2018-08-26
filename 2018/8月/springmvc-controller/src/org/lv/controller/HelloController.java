package org.lv.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * HelloController��һ��ʵ��controller�ӿڵĿ�����
 * ���Դ���һ����һ��������
 * @author 319667916
 *
 */
public class HelloController implements Controller{
	
	private static final Log logger = LogFactory.getLog(HelloController.class);

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("handleRequest������");
		ModelAndView mv = new ModelAndView();
		//���ģ�����ݣ������������POJO����
		mv.addObject("message","Hello World!!!  loooody");
		//�����߼���ͼ������ͼ����������ݸ����ֽ������������ͼҳ��
		mv.setViewName("WEB-INF/content/welcome.jsp");
		//����ModelAndView����
		return mv;
	}
	
	
}
