package org.lv;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("请输入您要进行匹配的字符串:");
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		
		isSymmetry(str);
	}
	
	
	public static boolean isSymmetry(String str) {
		//将输入的字符串转换为数组形式
		
		char[] a = new char[str.length()];
		for(int i = 0; i < str.length(); i++) {
			a[i] = str.charAt(i);
			System.out.println(a[i]);
		}
		
		//求字符串的长度的中点
		int mid = str.length() / 2 - 1;
		
		char[] s = new char[mid + 1];
		int top = 0; //栈顶位置
		//栈的初始化，将mid前的字符依次入栈
		for(int i = 0; i <= mid; i++)
			s[top++] = a[i];
		
		int next ;  //需要进行字符串匹配的起始下标
		//判断字符串的长度是奇数还是偶数，并找出需要进行字符串匹配的起始下标
		if(str.length() % 2 == 0)
			next = mid +1;
		else
			next = mid + 2;
		
		//开始匹配
		for(int j = next; j <= str.length() - 1; j++) {
			if(a[j] != s[top-1])
				break;
			top--;
		}
		
		//如果top的值为0，则说明栈内的所有字符都被一一匹配了
		if(top == 0) {
			System.out.println("匹配成功");
			return true;
		}
		System.out.println("匹配失败");
		return false;
	}
	
	
}
