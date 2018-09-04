package com.lv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lv.bean.Employee;
import com.lv.bean.Msg;
import com.lv.service.EmployeeService;

/**
 * 处理员工请求
 * 
 * @author 319667916
 *
 */
@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	/**
	 * 检查用户名是否可用
	 * @param empName
	 * @return
	 */
	@RequestMapping("/checkuser")
	@ResponseBody
	public Msg checkUser(@RequestParam ("empName")String empName) {
		boolean b = employeeService.checkuser(empName);
		if(b) {
			return Msg.success();
		}else {
			return Msg.fail();
		}
	}
	
	/**
	 * 员工保存
	 * @param pn
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/emps",method=RequestMethod.POST)
	@ResponseBody
	public Msg saveEmp(Employee employee) {
		employeeService.saveEmp(employee);
		return Msg.success();
	}
	
	@RequestMapping("/emps")
	@ResponseBody
	public Msg getEmpsWithJson(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
		// 这不是一个分页
		// 引入pageHelper分页插件
		// 在查询之前秩序调用，传入页码，以及煤业的大小
		System.out.println("1");
		PageHelper.startPage(pn, 5);
		List<Employee> emps = employeeService.getAll();
		// 使用PageInfo包装查询后的结果
		// 封装了详细的分页信息
		PageInfo page = new PageInfo(emps, 5);
		
		return Msg.success().add("pageInfo", page);
	}

	/**
	 * 查询员工数据（分页查询）
	 * 
	 * @return
	 */
	// @RequestMapping("/emps")
	public String getEmps(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {

		// 这不是一个分页
		// 引入pageHelper分页插件
		// 在查询之前秩序调用，传入页码，以及煤业的大小
	//	System.out.println("1");
		PageHelper.startPage(pn, 5);
		List<Employee> emps = employeeService.getAll();
		// 使用PageInfo包装查询后的结果
		// 封装了详细的分页信息
		PageInfo page = new PageInfo(emps, 5);
		model.addAttribute("pageInfo", page);

		return "list";
	}
}
