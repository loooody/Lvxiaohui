package org.lv;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("��������Ҫ����ƥ����ַ���:");
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		
		isSymmetry(str);
	}
	
	
	public static boolean isSymmetry(String str) {
		//��������ַ���ת��Ϊ������ʽ
		
		char[] a = new char[str.length()];
		for(int i = 0; i < str.length(); i++) {
			a[i] = str.charAt(i);
			System.out.println(a[i]);
		}
		
		//���ַ����ĳ��ȵ��е�
		int mid = str.length() / 2 - 1;
		
		char[] s = new char[mid + 1];
		int top = 0; //ջ��λ��
		//ջ�ĳ�ʼ������midǰ���ַ�������ջ
		for(int i = 0; i <= mid; i++)
			s[top++] = a[i];
		
		int next ;  //��Ҫ�����ַ���ƥ�����ʼ�±�
		//�ж��ַ����ĳ�������������ż�������ҳ���Ҫ�����ַ���ƥ�����ʼ�±�
		if(str.length() % 2 == 0)
			next = mid +1;
		else
			next = mid + 2;
		
		//��ʼƥ��
		for(int j = next; j <= str.length() - 1; j++) {
			if(a[j] != s[top-1])
				break;
			top--;
		}
		
		//���top��ֵΪ0����˵��ջ�ڵ������ַ�����һһƥ����
		if(top == 0) {
			System.out.println("ƥ��ɹ�");
			return true;
		}
		System.out.println("ƥ��ʧ��");
		return false;
	}
	
	
}
