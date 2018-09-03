package com.lv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lv.bean.Department;
import com.lv.dao.DepartmentMapper;

@Service
public class DepartmentServicee {

	@Autowired
	private DepartmentMapper departmentMapper;
	
	public List<Department> getDepts(){
		//返回所有部门信息
		return departmentMapper.selectByExample(null);
	}
}
