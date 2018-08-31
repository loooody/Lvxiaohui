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
	 * ����/mian����
	 */
	@RequestMapping(value="/main")
	public String main(Model model) {
		//�������ͼ�鼯��
		List<Book> book_list = bookService.getAll();
		//��ͼ�鼯����ӵ�model��
		model.addAttribute("book_list",book_list);
		//��ת��main
		return "main";
	}
}
