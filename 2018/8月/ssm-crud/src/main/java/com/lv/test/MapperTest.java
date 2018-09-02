package com.lv.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lv.bean.Department;
import com.lv.bean.Employee;
import com.lv.dao.DepartmentMapper;
import com.lv.dao.EmployeeMapper;

/**
 * 测试dao层的工作
 * @author 319667916
 *推荐使用Spring的项目就可以使用SPring的的单元测试
 *1.导入SpringTest模块
 *2.@ContextConfiguration指定Spring配置文件的位置
 *3.直接autowired要用的组件即可
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {
	
	@Autowired
	DepartmentMapper departMapper;
	
	@Autowired
	EmployeeMapper employeeMapper;
	/**
	 * 测试DepartmentMapper
	 */
	@Test
	public void testCRUD() {
		System.out.println(departMapper);
		
		//1.插入几个部门
	//	departMapper.insertSelective(new Department(null,"开发部"));
	//	departMapper.insertSelective(new Department(null,"测试部"));
		
		//2。生成员工数据，测试员工插入
		employeeMapper.insertSelective(new Employee(null,"loooody","M","loooody@qq.com"));
	}
}
