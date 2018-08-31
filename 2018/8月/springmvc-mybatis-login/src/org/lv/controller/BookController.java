package org.lv.controller;

import java.util.ArrayList;
import java.util.List;

import org.lv.domain.Book;
import org.lv.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
	
	@Autowired
	@Qualifier("bookService")
	private BookService bookService;
	/**
	 * 处理/mian请求
	 */
	@RequestMapping(value="/main")
	public String main(Model model) {
		//获得所有图书集合
		List<Book> book_list = bookService.getAll();
		//将图书集合添加到model中
		model.addAttribute("book_list",book_list);
		//跳转到main
		return "main";
	}
}
