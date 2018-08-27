package org.lv.controller;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lv.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("/json")
public class BookController {
	
	private static final Log logger = LogFactory.getLog(BookController.class);
	
	//@RequestBody����json���ݣ�ת���ɶ�Ӧ��Object
	@RequestMapping(value="/testRequestBody")
	public void setJson(@RequestBody Book book,
			HttpServletResponse response) throws Exception{
		
		//��Book����ת����json���
		logger.info(JSONObject.toJSONString(book));
		book.setAuthor("loooody");
		response.setContentType("text/html;charset=UTF-8");
		//��book����ת����jsonд�����ͻ���
		response.getWriter().println(JSONObject.toJSONString(book));
	}
}
