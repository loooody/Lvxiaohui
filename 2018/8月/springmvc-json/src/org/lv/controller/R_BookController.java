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
	//@ResponseBody会将集合数据转换为json格式并将其返回客户端
	@ResponseBody
	public Object getJson() {
		List<Book> list = new ArrayList<Book>();
		list.add(new Book(1,"Spring MVC企业版应用实战","loooody"));
		list.add(new Book(2,"java编程思想","json"));
		return list;
	}
}
