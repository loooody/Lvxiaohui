package bucketSort;

import java.util.Scanner;

public class test {
	public static void bucket() {
		int[] bucket = new int[1001];
		
		//输入将要排序的数字的个数
		System.out.print("请输入您将要进行排序的数字个数：");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		
		for(int i = 0;i < num; i++) {
			System.out.print("第" + (i+1) +"个数：");
			int j = input.nextInt();
			if(j > 1000 || j < 0) {
				System.out.println("输入的数字过大或过小，请重新输入");
				i--;
				continue;
			}
			bucket[j]++;
		}
	
		//输出排序后的数据
		System.out.println("最后的排序结果为:");
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
