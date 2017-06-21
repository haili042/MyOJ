package com.haili.xiecheng;

import java.util.Scanner;

public class T1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		while (in.hasNext()) {
			String str = in.nextLine();
			String[] ss = str.split(",");
			
			int[] a = new int[1002];
			for (int i = 0; i < ss.length; i++) {
				a[i+1] = Integer.parseInt(ss[i]);
			}
			t1(a, ss.length);
		}
//		String str = "2,3,2,4";
//		String[] ss = str.split(",");
//		
//		int[] a = new int[1002];
//		for (int i = 0; i < ss.length; i++) {
//			a[i+1] = Integer.parseInt(ss[i]);
//		}
//		t1(a, ss.length);
		
	}

	
	public static int t1(int[] stock, int n) {
		int m = 1;
		int[][] f = new int[1001][1001];
		
		for (int j = 1; j <= 1; j++) {
			f[1][j] = 0;
			int t = -stock[1];
			for (int i = 2; i <= n; i++) {
				f[i][j] = Math.max(f[i - 1][j],
						Math.max(f[i][j - 1], stock[i] + t));
				if (t < f[i - 1][j - 1] - stock[i]) {
					
					t = f[i - 1][j - 1] - stock[i];
				}
			}// for
		}// for
		System.out.println(f[n][m]);
		return f[n][m];
	}

}
