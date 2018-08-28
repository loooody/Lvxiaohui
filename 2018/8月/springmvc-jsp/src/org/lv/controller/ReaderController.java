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
		//����Boolean������ֵΪtrue��ҳ���checkbox��ѡ��ᱻѡ��
		reader.setReader(true);
		//Ϊ���ϱ���courses��ӡ�java���͡�spring����ҳ��ĸ�ѡ����������ᱻѡ��
		List<String> list = new ArrayList<String>();
		list.add("java");
		list.add("spring");
		reader.setCourses(list);
		//model���������reader��ֵ��Reader����
		model.addAttribute("reader",reader);
		return "checkbox";
	}
}
