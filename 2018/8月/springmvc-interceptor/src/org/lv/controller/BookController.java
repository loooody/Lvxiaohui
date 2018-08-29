package org.lv.controller;

import java.util.ArrayList;
import java.util.List;

import org.lv.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
	
	/**
	 * 处理/mian请求
	 */
	@RequestMapping(value="/main")
	public String main(Model model) {
		//模拟数据库获得所有图书集合
		List<Book> book_list = new ArrayList<Book>();
		book_list.add(new Book("java.jpg","java","loooody",88));
		book_list.add(new Book("python.jpg","python","loooody",58));
		book_list.add(new Book("c.jpg","c","loooody",88));
		book_list.add(new Book("c#.jpg","c#","loooody",88));
		//将图书集合添加到model中
		model.addAttribute("book_list",book_list);
		//跳转到main
		return "main";
	}
}
