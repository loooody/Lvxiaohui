package org.lv.service.impl;

import java.util.List;

import org.lv.domain.Book;
import org.lv.mapper.BookMapper;
import org.lv.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bookService")
public class BookServiceImpl implements BookService{
	/**
	 * ×Ô¶¯×¢Èë
	 */
	@Autowired
	private BookMapper bookMapper;
	
	public List<Book> getAll(){
		return bookMapper.findAll();
	}
}
