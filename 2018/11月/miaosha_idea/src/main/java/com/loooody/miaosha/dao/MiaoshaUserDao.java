package com.loooody.miaosha.dao;

import com.loooody.miaosha.domain.MiaoshaUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MiaoshaUserDao {

    @Select("select * from user where id = #{id}")
    public MiaoshaUser getById(@Param("id")long id);
}
