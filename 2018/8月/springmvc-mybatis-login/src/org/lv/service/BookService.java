package org.lv.service;

import java.util.List;

import org.lv.domain.Book;

public interface BookService {
	/**
	 * 查找所有图书
	 */
	List<Book> getAll();
}
