package org.lv.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * HelloController是一个基于注解的控制器
 * 可以同时处理多个请求动作，并且无须实现任务接口
 * @author 319667916
 *
 */
@Controller
public class HelloController{
	
	private static final Log logger = LogFactory.getLog(HelloController.class);

	@RequestMapping(value="/hello")
	public ModelAndView hello() {
		logger.info("hello方法被调用");
		//创建准备返回的ModelAndView对象
		ModelAndView mv = new ModelAndView();
		//添加模型数据
		mv.addObject("message","hello !!!");
		//设置视图名
		mv.setViewName("WEB-INF/content/welcome.jsp");
		return mv;
	}
	
	
}
