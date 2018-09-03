package com.lv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lv.bean.Department;
import com.lv.bean.Msg;
import com.lv.service.DepartmentServicee;

/**
 * 处理和部门有关的请求
 * @author 319667916
 *
 */
@Controller
public class DepartmentController {

	@Autowired
	private DepartmentServicee departmentService;
	
	/*
	 * 返回所有的部门信息
	 */
	@RequestMapping("/depts")
	@ResponseBody
	public Msg getAllDetp() {
		List<Department> list = departmentService.getDepts();
		return Msg.success().add("depts",list);
	}
}
