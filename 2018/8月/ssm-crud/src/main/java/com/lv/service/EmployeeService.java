package com.lv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lv.bean.Employee;
import com.lv.bean.EmployeeExample;
import com.lv.bean.EmployeeExample.Criteria;
import com.lv.bean.Msg;
import com.lv.dao.EmployeeMapper;

@Service
public class EmployeeService {

	@Autowired
	EmployeeMapper employeeMapper;
	
	/**
	 * 查询所有员工
	 * @return
	 */
	public List<Employee> getAll(){
	//	System.out.println("到这里");
		return employeeMapper.selectByExampleWithDept(null);
	}

	public void saveEmp(Employee employee) {
		// TODO Auto-generated method stub
		employeeMapper.insertSelective(employee);
	}

	/**
	 * 检验用户名是否存在
	 * @param empName
	 * @return true:代表当前姓名可用
	 */
	public boolean checkuser(String empName) {
		// TODO Auto-generated method stub
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmpNameEqualTo(empName);
		long count = employeeMapper.countByExample(example);
		return count == 0;
	}

	/**
	 * 按照员工id查询员工
	 * @param id
	 * @return
	 */
	public Employee getEmp(Integer id) {
		// TODO Auto-generated method stub
		
		Employee employee = employeeMapper.selectByPrimaryKeyWithDept(id);
		return employee;
	}

	/**
	 * 员工更新
	 * @param employee
	 */
	public void updateEmp(Employee employee) {
		// TODO Auto-generated method stub
		employeeMapper.updateByPrimaryKeySelective(employee);
	}

}
