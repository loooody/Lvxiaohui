package string_operator;

import java.util.Arrays;

/**
 * 如果IDE没有代码自动补全功能
 * 应该记下关于字符串的方法
 * @author 319667916
 *
 */
public class Main {
	
	public static void main(String[] args) {
	//1获得字符串对应的char数组
	String str = "loooody";
	System.out.println(str.toCharArray());
	
	//2将数组进行排序
	int[] arr = {2,5,3,4,0,1};
	Arrays.sort(arr);
	for(int s : arr)
	System.out.print(s + "  ");
	System.out.println();
	
	//3将数组转成字符串
	System.out.println(Arrays.toString(arr));
	
	//4获得某个索引处的字符
	System.out.println(str.charAt(6));
	
	//5字符串长度
	System.out.println(str.length());
	
	//6数组大小
	System.out.println(arr.length);
	}
}
