package org.lv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/** HelloController��һ������ע��Ŀ�����
 * ����ͬʱ����������������������ʵ������ӿ�
 * @author 319667916
 *
 */
@Controller
public class HelloController{

	@RequestMapping(value="/helloWorld")
	public String index(Model model) {
		System.out.println("����");
		model.addAttribute("message","Hello world");
		return "index";
	}
	
	
}
