package org.lv;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		int inf = 99999999; //正无穷
		
		Scanner input = new Scanner(System.in);
		//顶点个数
		System.out.print("顶点个数:");
		int vertex = input.nextInt();
		//边的条数
		System.out.print("边的条数:");
		int side = input.nextInt();
		
		int[][] e = new int[vertex+1][vertex+1];
		
		//初始化
		for(int i = 1; i <= vertex; i++) {
			for(int j = 1; j <= vertex; j++) {
				if(i == j) {
					e[i][j] = 0;
				}
				else {
					e[i][j] = inf;
				}
			}
		}
		
		//读入边
		for(int i = 1; i <= side; i++) {
			System.out.println("第" + i + "条边：");
			System.out.print("顶点1:");
			int vertex1 = input.nextInt();
			System.out.print("顶点2:");
			int vertex2 = input.nextInt();
			System.out.print("顶点1与顶点2间的长度:");
			int length = input.nextInt();
			e[vertex1][vertex2] = length;
			System.out.println("录入的边为:" + vertex1 + "-->" + vertex2 + " = " + length + "\n");
			
		}
		
		//Floyd算法核心语句
		for(int i = 1; i <= vertex; i++)
			for(int j = 1; j <= vertex; j++)
				for(int k = 1; k <= vertex; k++)
					if(e[j][k] > e[j][i] + e[i][k])
						e[j][k] = e[j][i] + e[i][k];
		
		//输出最终的结果
		System.out.println("最终生成的矩阵为:");
		for(int i = 1; i <= vertex; i++) {
			for(int j = 1; j<= vertex; j++) {
				System.out.print(e[i][j] + "   ");
			}
			System.out.println();
		}
	}
}
