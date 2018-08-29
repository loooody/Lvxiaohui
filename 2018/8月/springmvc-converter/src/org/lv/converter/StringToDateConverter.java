package org.lv.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

//ʵ��Converter<S,T>�ӿ�
public class StringToDateConverter implements Converter<String,Date>{
	//��������ģ�壺��yyyy-MM-dd
	private String datePattern;
	public void setDatePattern(String datePattern) {
		this.datePattern = datePattern;
	}
	
	//Converter<S,T>�ӿڵ�����ת������
	public Date convert(String date) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(this.datePattern);
		//�������ַ���ת����Date���ͷ���
			return dateFormat.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("����ת��ʧ��");
			return null;
		}
	}
}
