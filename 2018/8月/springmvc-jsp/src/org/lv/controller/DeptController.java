package org.lv.controller;

import java.util.HashMap;
import java.util.Map;

import org.lv.domain.Dept;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DeptController {
	@RequestMapping(value="/selectForm",method=RequestMethod.GET)
	
	public String selectForm(Model model) {
		Dept dept = new Dept();
		dept.setDeptId(2);
		//ҳ��չ�ֵĿɹ�ѡ���select����������deptMap
		Map<Integer,String> deptMap = new HashMap<Integer,String>();
		deptMap.put(1,"����");
		deptMap.put(2, "������");
		deptMap.put(3, "���۲�");
		model.addAttribute("dept",dept);
		model.addAttribute("deptMap",deptMap);
		return "selectForm";
	}
}
