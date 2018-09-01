package testCharset;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class Main {

	public static void main(String[] args) throws UnsupportedEncodingException {
		charSet();
		
		correct_charSet();
		
		getByte_encoding();
	}
	
	public static void charSet() {
		String strChineseString = "����";
		String encoding = System.getProperty("file.encoding");
		System.out.println("ϵͳĬ�ϵ��ַ����ǣ�" + encoding);
		System.out.println(strChineseString.getBytes(Charset.forName("GBK")).length);
		System.out.println(strChineseString.getBytes(Charset.forName("UTF-8")).length);
		System.out.println(strChineseString.getBytes().length+"\n");
		
	}
	
	/**
	 * ʹ�������ַ�������һ��String��������һ��String��ʱ��ͱ���ʹ����Ӧ�ı���
	 * ����ͻ��������
	 * @throws UnsupportedEncodingException
	 */
	public static void correct_charSet() throws UnsupportedEncodingException {
		String strChineseString = "����";
		byte[] byteGBK = null;
		byte[] byteUTF = null;
		byteGBK = strChineseString.getBytes(Charset.forName("GBK"));
		byteUTF = strChineseString.getBytes(Charset.forName("UTF-8"));
		System.out.println(new String(byteGBK,"GBK"));
		System.out.println(new String(byteGBK,"UTF-8"));
		System.out.println("-------------");
		System.out.println(new String(byteUTF,"GBK"));
		System.out.println(new String(byteUTF,"UTF-8")+"\n");
	}
	
	/**
	 * ��ȷ��ת��
	 * @throws UnsupportedEncodingException 
	 */
	public static void getByte_encoding() throws UnsupportedEncodingException {
		String strSource = "��Ҫת����ַ���";
		String strSomeEncoding = "utf-8";
		String strTarget = new String(strSource.getBytes(Charset.forName(strSomeEncoding)),strSomeEncoding);
		System.out.println(strTarget);
	}
}
