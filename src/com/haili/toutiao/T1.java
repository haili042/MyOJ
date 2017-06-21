package com.haili.toutiao;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * 输入 n 和 m 把从 1 到 n的字典序排序的 第m个 个数输出
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
			int zushu = (int) Math.ceil(m * 1.0 / (f[n - 1] + 1)); // 计算所属组数
			if (!flag)
				System.out.printf(" ");
			flag = false;
			System.out.printf("%d", num[zushu]);
			for (int i = zushu; i < n; i++)
				// 合并掉这个位置
				num[i] = num[i + 1];
			m = (int) (m - (zushu - 1) * (f[n - 1] + 1) - 1); // -1是因为第一个只有一个数字
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

	// 第二方法
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
