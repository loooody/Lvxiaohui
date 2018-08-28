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
		//页面展现的可供选择的select下拉框内容deptMap
		Map<Integer,String> deptMap = new HashMap<Integer,String>();
		deptMap.put(1,"财务部");
		deptMap.put(2, "开发部");
		deptMap.put(3, "销售部");
		model.addAttribute("dept",dept);
		model.addAttribute("deptMap",deptMap);
		return "selectForm";
	}
}
