package org.lv;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		int inf = 99999999; //������
		
		Scanner input = new Scanner(System.in);
		//�������
		System.out.print("�������:");
		int vertex = input.nextInt();
		//�ߵ�����
		System.out.print("�ߵ�����:");
		int side = input.nextInt();
		
		int[][] e = new int[vertex+1][vertex+1];
		
		//��ʼ��
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
		
		//�����
		for(int i = 1; i <= side; i++) {
			System.out.println("��" + i + "���ߣ�");
			System.out.print("����1:");
			int vertex1 = input.nextInt();
			System.out.print("����2:");
			int vertex2 = input.nextInt();
			System.out.print("����1�붥��2��ĳ���:");
			int length = input.nextInt();
			e[vertex1][vertex2] = length;
			System.out.println("¼��ı�Ϊ:" + vertex1 + "-->" + vertex2 + " = " + length + "\n");
			
		}
		
		//Floyd�㷨�������
		for(int i = 1; i <= vertex; i++)
			for(int j = 1; j <= vertex; j++)
				for(int k = 1; k <= vertex; k++)
					if(e[j][k] > e[j][i] + e[i][k])
						e[j][k] = e[j][i] + e[i][k];
		
		//������յĽ��
		System.out.println("�������ɵľ���Ϊ:");
		for(int i = 1; i <= vertex; i++) {
			for(int j = 1; j<= vertex; j++) {
				System.out.print(e[i][j] + "   ");
			}
			System.out.println();
		}
	}
}
