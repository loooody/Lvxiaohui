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
		String strChineseString = "中文";
		String encoding = System.getProperty("file.encoding");
		System.out.println("系统默认的字符集是：" + encoding);
		System.out.println(strChineseString.getBytes(Charset.forName("GBK")).length);
		System.out.println(strChineseString.getBytes(Charset.forName("UTF-8")).length);
		System.out.println(strChineseString.getBytes().length+"\n");
		
	}
	
	/**
	 * 使用哪种字符集编码一个String，在生成一个String的时候就必须使用响应的编码
	 * 否则就会出现乱码
	 * @throws UnsupportedEncodingException
	 */
	public static void correct_charSet() throws UnsupportedEncodingException {
		String strChineseString = "中文";
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
	 * 正确的转码
	 * @throws UnsupportedEncodingException 
	 */
	public static void getByte_encoding() throws UnsupportedEncodingException {
		String strSource = "需要转码的字符串";
		String strSomeEncoding = "utf-8";
		String strTarget = new String(strSource.getBytes(Charset.forName(strSomeEncoding)),strSomeEncoding);
		System.out.println(strTarget);
	}
}
