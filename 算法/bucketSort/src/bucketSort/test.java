package bucketSort;

import java.util.Scanner;

public class test {
	public static void bucket() {
		int[] bucket = new int[1001];
		
		//���뽫Ҫ��������ֵĸ���
		System.out.print("����������Ҫ������������ָ�����");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		
		for(int i = 0;i < num; i++) {
			System.out.print("��" + (i+1) +"������");
			int j = input.nextInt();
			if(j > 1000 || j < 0) {
				System.out.println("��������ֹ�����С������������");
				i--;
				continue;
			}
			bucket[j]++;
		}
	
		//�������������
		System.out.println("����������Ϊ:");
		for(int i = 1000; i >=0; i--) {
			for(int j = 0;j < bucket[i]; j++) {
				System.out.print(i + " ");
			}
		}
	}
	
	public static void main(String[] args) {
		bucket();
	}
	
}
