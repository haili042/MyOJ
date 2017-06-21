package com.haili.sougou;

import java.util.Scanner;

/***
 * 规定两个大于2的偶数的距离是这两个数之间质数的个数, 从小到达输入n个大于2 的偶数, 输出所有数两两之间的距离总和
 * 
 * input
 * > 2 // 总个数
 * > 4
 * > 6
 * > 12
 * 
 * output
 * > 6
 * 
 * */

public class T1 {
	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		int num = in.nextInt();
//		int[] arr = new int[num];
//
//		Scanner in2 = new Scanner(System.in);
//		for (int i = 0; i < num; i++) {
//			arr[i] = in.nextInt();
//		}
		int [] arr = {4, 6, 12, 16};
		System.out.println(ti(arr));
	}

	public static int ti(int[] arr) {
		int res = 0;
		int len = arr.length;
		int[] sums = new int[len-1];
		
		for (int i = 0; i < len - 1; i++) {
			sums[i] = zhishuCount(arr[i], arr[i+1]);
		}
		
			
		for (int j = 0; j < sums.length; j++) {
			int ll = len - 1 - j;
			for (int i = ll; i > 0; i--) {
				res += sums[ll-i] * i;
			}
			
			for (int i = 1; i < sums.length; i++) {
				sums[i-1] = sums[i];
			}
			sums[sums.length - 1] = 0;
		}
		

		return res;
	}

	public static int zhishuCount(int start, int end) {
		int i, j, res = 0;
		for (i = start; i <= end; i++) {
			for (j = 2; j <= i / 2; j++) {
				if (i % j == 0) {
					break;
				}
			}
			if (j > i / 2) {
				res++;
				System.out.println("数" + i + "是质数");
			}
		}
		return res;
	}

}
