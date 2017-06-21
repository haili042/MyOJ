package com.haili.toutiao;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * ���� n �� m �Ѵ� 1 �� n���ֵ�������� ��m�� �������
 * 
 * case input 11 4
 * 
 * output 2
 * 
 * 
 * */
public class T1 {

	static void work(int n, int m) {
		long[] f = new long[25];
		f[0] = 0;
		for (int i = 1; i <= 20; i++)
			f[i] = i * (f[i - 1] + 1);

		int[] num = new int[25];
		for (int i = 1; i <= n; i++)
			num[i] = i;
		boolean flag = true;
		while (m > 0) {
			int zushu = (int) Math.ceil(m * 1.0 / (f[n - 1] + 1)); // ������������
			if (!flag)
				System.out.printf(" ");
			flag = false;
			System.out.printf("%d", num[zushu]);
			for (int i = zushu; i < n; i++)
				// �ϲ������λ��
				num[i] = num[i + 1];
			m = (int) (m - (zushu - 1) * (f[n - 1] + 1) - 1); // -1����Ϊ��һ��ֻ��һ������
			n--;
		}
		System.out.printf("\n");
	}

	/*------------------Main Function------------------*/
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		while (in.hasNext()) {

			int n = in.nextInt();
			int m = in.nextInt();
			work(n, m);
		}
	}

	// �ڶ�����
	public static void main2(String[] args) {

		Scanner in = new Scanner(System.in);

		while (in.hasNext()) {

			int n = in.nextInt();
			int m = in.nextInt();
			String[] sarr = new String[n];

			for (int i = 0; i < n; i++) {
				sarr[i] = (i + 1) + "";
			}

			Arrays.sort(sarr);
			System.out.println(sarr[m - 1]);
		}
	}

}
