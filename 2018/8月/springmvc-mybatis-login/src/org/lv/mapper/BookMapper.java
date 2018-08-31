package org.lv.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.lv.domain.Book;

public interface BookMapper {
	/*
	 * 查询所有图书
	 */
	@Select("select * from tb_book")
	List<Book> findAll();
}
