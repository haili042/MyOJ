package com.haili.meituan;

import java.util.Scanner;

public class T1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		Scanner in2 = new Scanner(System.in);
		while (in2.hasNext()) {
			for (int i = 0; i < N; i++) {
				String str = in2.nextLine();
				String[] strs = str.split(",");
				int[] nums = new int[strs.length];
				for (int j = 0; j < strs.length; j++) {
					nums[j] = Integer.parseInt(strs[j]);
				}
				System.out.println(t(nums, nums.length));
			}
		}
		in2.close();
	}

	public static String t(int[] a, int n) {
		String res = "";
		int[] dp = new int[n + 1];

		dp[1] = Math.max(a[0], a[1]);

		for (int j = 1; j < n; j++) {
			// 2个数之最多隔2个数，隔3个数是不可能的
			for (int i = 2; i <= 3; i++){
				if (j >= i) {
					dp[j] = Math.max(dp[j], dp[j - i] + a[j]);

				}
			}
			dp[j + 1] = dp[j];
		}

		res = dp[n - 1] + "";
		return res;
	}
}
