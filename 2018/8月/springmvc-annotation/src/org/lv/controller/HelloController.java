package org.lv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/** HelloController是一个基于注解的控制器
 * 可以同时处理多个请求动作，并且无须实现任务接口
 * @author 319667916
 *
 */
@Controller
public class HelloController{

	@RequestMapping(value="/helloWorld")
	public String index(Model model) {
		System.out.println("进入");
		model.addAttribute("message","Hello world");
		return "index";
	}
	
	
}
