package com.haili.exam.test;

import java.util.Scanner;

public class Snack {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[][] date = new int[n][n];
		int number = 1;
		int xunhuan = 0;// Ȧ��
		if (n / 2 == 0) {
			xunhuan = n;// �����ѭ��Ȧ��
		} else {
			xunhuan = n + 1;// ����ѭ��Ȧ��
		}
		for (int m = 0; m < xunhuan; m++)// ����Ļ���
		{
			for (int i = m; i < n - m; i++) {
				date[m][i] = number;
				number++;
			}
			for (int i = m + 1; i < n - m; i++) {
				date[i][n - m - 1] = number;
				number++;
			}
			for (int i = n - m - 2; i >= m; i--) {
				date[n - m - 1][i] = number;
				number++;
			}
			for (int i = n - m - 2; i > m; i--) {
				date[i][m] = number;
				number++;
			}
		}
		for (int i = 0; i < date.length; i++)// ���
		{
			for (int j = 0; j < date[i].length; j++) {
				System.out.print(date[i][j] + " ");
			}
		}
	}

}