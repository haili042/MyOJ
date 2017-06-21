package com.haili.toutiao;

import java.util.Scanner;


/**
 * 一个病毒, 每秒钟会导致 A->B, B->BA
 * 如: (从上到下是每秒钟的变化)
 * A
 * B
 * BA
 * BAB
 * BABBA
 * ...
 * 
 * 
 * 现在有一个文件只有A, 经过n秒后包含了多少个A, 和B?
 * 
 * case
 * input
 * >	1
 * 
 * ouput
 * >	0	1
 * 
 * 
 * */
public class T2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			t(n);
		}
	}
	
	public static void t(int n) {
		System.out.println(fibonaci(n - 1) + " " + fibonaci(n));
	}
	
	public static int fibonaci(int n) {
		
		if (n < 0) return 0;
		double a1 = (1 + Math.sqrt(5)) / 2;
		double a2 = (1 - Math.sqrt(5)) / 2;
		double m1 = Math.pow(a1, n);
		double m2 = Math.pow(a2, n);
		
		int res = (int) (1 / Math.sqrt(5) * (m1 - m2));
		return res;
	}

}
