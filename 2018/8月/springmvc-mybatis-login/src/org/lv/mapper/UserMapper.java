package org.lv.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.lv.domain.User;

public interface UserMapper  {
	/**
	 * ���ݵ�¼������������ѯ�û�
	 */
	@Select("select * from tb_user where loginname = #{loginname} and password = #{password}")

	User findWithLoginnameAndPassword(@Param("loginname")String loginname,@Param("password") String password);
}
