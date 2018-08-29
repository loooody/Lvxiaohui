package org.lv.converter;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

//�Զ������Ա༭��
public class DateEditor extends PropertyEditorSupport{
	//��������ַ�������ת����Date����
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
