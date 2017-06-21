package com.haili.zhongxing;

public class T2 {
	public static void main(String[] args) {
		int n = 5;
		p(5);
	}
	
	// 如果n=5，则阵列为：
	// 1
	// 3*2
	// 4*5*6
	// 10*9*8*7
	// 11*12*13*14*15
	public static void p(int n) {
		
		int count = 0;
		for (int i = 1; i <= n; i++) {
			String s = "";
			for (int j = 1; j <= i; j++) {
				if (i % 2 == 0) {
					s += ( i * i - count++) + "*";
				} else {
					s += ++count + "*";
				}
			}
			System.out.println(s.substring(0, s.length() - 1));
		}
	}
	
}
