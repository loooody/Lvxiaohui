package string_operator;

import java.util.Arrays;

/**
 * ���IDEû�д����Զ���ȫ����
 * Ӧ�ü��¹����ַ����ķ���
 * @author 319667916
 *
 */
public class Main {
	
	public static void main(String[] args) {
	//1����ַ�����Ӧ��char����
	String str = "loooody";
	System.out.println(str.toCharArray());
	
	//2�������������
	int[] arr = {2,5,3,4,0,1};
	Arrays.sort(arr);
	for(int s : arr)
	System.out.print(s + "  ");
	System.out.println();
	
	//3������ת���ַ���
	System.out.println(Arrays.toString(arr));
	
	//4���ĳ�����������ַ�
	System.out.println(str.charAt(6));
	
	//5�ַ�������
	System.out.println(str.length());
	
	//6�����С
	System.out.println(arr.length);
	}
}
