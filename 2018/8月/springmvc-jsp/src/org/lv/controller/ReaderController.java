package org.lv.controller;

import java.util.ArrayList;
import java.util.List;

import org.lv.domain.Reader1;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReaderController {
	
	@RequestMapping(value="/checkboxForm",method=RequestMethod.GET)
	public String checkForm(Model model) {
		Reader1 reader = new Reader1();
		//设置Boolean变量的值为true，页面的checkbox复选框会被选中
		reader.setReader(true);
		//为集合变量courses添加”java“和”spring“，页面的复选框中这两项会被选中
		List<String> list = new ArrayList<String>();
		list.add("java");
		list.add("spring");
		reader.setCourses(list);
		//model中添加属性reader，值是Reader对象
		model.addAttribute("reader",reader);
		return "checkbox";
	}
}
