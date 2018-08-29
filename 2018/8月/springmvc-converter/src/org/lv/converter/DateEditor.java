package org.lv.converter;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

//自定义属性编辑器
public class DateEditor extends PropertyEditorSupport{
	//将传入的字符串数据转换成Date类型
	public void setAsText(String text) throws IllegalArgumentException{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		try {
			date = dateFormat.parse(text);
			setValue(date);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
