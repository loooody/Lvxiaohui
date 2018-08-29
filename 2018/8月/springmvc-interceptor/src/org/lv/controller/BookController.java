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
	 * ����/mian����
	 */
	@RequestMapping(value="/main")
	public String main(Model model) {
		//ģ�����ݿ�������ͼ�鼯��
		List<Book> book_list = new ArrayList<Book>();
		book_list.add(new Book("java.jpg","java","loooody",88));
		book_list.add(new Book("python.jpg","python","loooody",58));
		book_list.add(new Book("c.jpg","c","loooody",88));
		book_list.add(new Book("c#.jpg","c#","loooody",88));
		//��ͼ�鼯����ӵ�model��
		model.addAttribute("book_list",book_list);
		//��ת��main
		return "main";
	}
}
