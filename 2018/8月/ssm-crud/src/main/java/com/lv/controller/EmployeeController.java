package com.lv.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
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
	 * 如果直接发送ajax=PUT请求
	 * 
	 * 员工更新方法
	 * @param employee
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/emps/{empId}",method=RequestMethod.PUT)
	public Msg saveEmp(Employee employee) {
		System.out.println(employee);
		employeeService.updateEmp(employee);
		return Msg.success();
	}
	
	
	/**
	 * 根据id查询员工
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/emps/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Msg getEmp(@PathVariable("id") Integer id) {
		
		Employee employee = employeeService.getEmp(id);
		
		return Msg.success().add("emp", employee);
	}
	
	/**
	 * 检查用户名是否可用
	 * @param empName
	 * @return
	 */
	@RequestMapping("/checkuser")
	@ResponseBody
	public Msg checkUser(@RequestParam ("empName")String empName) {
		//判断用户名是否是合法的表达式
		String regx = "(^[a-z0-9_-]{6,16}$)|(^[\\u2E80-\\u9FFF]{2,5})";
		if(!empName.matches(regx)) {
			return Msg.fail().add("va_msg", "用户名必须是2-5位中文或者6-16位英文和数字的组合");
		}
		
		//数据库用户名重复校验
		boolean b = employeeService.checkuser(empName);
		if(b) {
			return Msg.success();
		}else {
			return Msg.fail().add("va_msg", "用户名已存在");
		}
	}
	
	/**
	 * 员工保存
	 * 1.支持
	 * @param pn
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/emps",method=RequestMethod.POST)
	@ResponseBody
	public Msg saveEmp(@Valid Employee employee,BindingResult result) {
		if(result.hasErrors()) {
			//校验失败，应该返回失败，在模态框中显示校验失败的错误信息
			Map<String,Object> map = new HashMap<String,Object>();
			
			List<FieldError> errors = result.getFieldErrors();
			for(FieldError fieldError : errors) {
				System.out.println("错误的字段：" + fieldError.getField());
				System.out.println("错误信息：" + fieldError.getDefaultMessage());
				map.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			return Msg.fail().add("emp_error", map);
		}else {
			employeeService.saveEmp(employee);
			return Msg.success();
		}
		
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
