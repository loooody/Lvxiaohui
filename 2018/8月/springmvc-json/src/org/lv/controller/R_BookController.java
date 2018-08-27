package org.lv.controller;

import java.util.ArrayList;
import java.util.List;

import org.lv.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/json")
public class R_BookController {
	
	@RequestMapping(value="/testResponseBody")
	//@ResponseBody�Ὣ��������ת��Ϊjson��ʽ�����䷵�ؿͻ���
	@ResponseBody
	public Object getJson() {
		List<Book> list = new ArrayList<Book>();
		list.add(new Book(1,"Spring MVC��ҵ��Ӧ��ʵս","loooody"));
		list.add(new Book(2,"java���˼��","json"));
		return list;
	}
}
