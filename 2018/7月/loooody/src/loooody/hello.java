package loooody;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class hello{
	//要进行截取操作的字符串
	static String ss;
	//街区的字符串的字节数
	static int n;
	
	public static void main(String[] args) {
		System.out.println("请输入要进行处理的字符串：");
		Scanner input = new Scanner(System.in);
		ss = input.nextLine();
		System.out.println("请输入字节数:");
		n = input.nextInt();
		interception(setValue());
	}
	
	//将字符串转化为字符数组
	public static String[] setValue() {
		String[] str = new String[ss.length()];
		for (int i=0;i<str.length;i++) {
			str[i] = ss.substring(i, i+1);
			//将字符串ss中的第i个值取出，放入字符数组中
		}
		
		return str;
	}
	
	//进行字节处理
	public static void interception(String[] str) {
		int count = 0;
		String m = "[\u4e00-\u9fa5]";
		System.out.println("以每"+n+"字符划分的字符串如下所示:");
		for(int i=0;i<str.length;i++) {
			if(str[i].matches(m)) {
				//将字符数组中的每一个元素与正则表达示进行匹配，如果相同则返回true
				count = count+2;
				
			}else {
				count = count+1;
			}
			if(count<n) {
				System.out.print(str[i]);
				
			}else if(count == n) {
				System.out.print(str[i]);
				count = 0;
				System.out.println();
			}else {
				count = 0;
				System.out.println();
			}
		}
	}
}
