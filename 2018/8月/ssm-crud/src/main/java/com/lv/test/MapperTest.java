package com.lv.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
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
	
	@Autowired
	SqlSession sqlSession;
	/**
	 * 测试DepartmentMapper
	 */
	@Test
	public void testCRUD() {
		System.out.println(departMapper);
		
		//1.插入几个部门
		departMapper.insertSelective(new Department(null,"开发部"));
		departMapper.insertSelective(new Department(null,"测试部"));
		
		//2。生成员工数据，测试员工插入
	//	employeeMapper.insertSelective(new Employee(null,"loooody","M","loooody@qq.com"));
		
		//3.批量插入多个员工：批量，使用可以执行批量的sqlSession
//		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//		for(int i = 0; i < 1000; i++) {
//			String uid = UUID.randomUUID().toString().substring(0, 5) + i;
//			mapper.insertSelective(new Employee(null,uid, "M", uid+"@loooody.com"));
//		}
//		System.out.println("批量完成");
		
//		Employee e = employeeMapper.selectByPrimaryKeyWithDept(1);
//		System.out.println(e.getEmpName());
		
		//4.查询员工
//		 departMapper.deleteByPrimaryKey(2);
//		 System.out.println("删除成功");
	}
}
