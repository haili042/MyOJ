package com.haili.alogrithm.backtrack;


/**
 * 8�ʺ�����
 * 
 * */
public class Queen {
	
	private static int[] x = new int [1000];
	private static int n;
	private static long sum = 0;

	public static void main(String[] args) {

		n = 8;
		backtrack(1);
		System.out.println(sum);
	}
	
	/**
	 * �����Ƿ����, ����������˻�t+1��
	 * 
	 * */
	public static boolean place(int k) {
		
		for (int i = 1; i < k; i++) {
			if (Math.abs(k - i) == Math.abs(x[i] - x[k]) || (x[i] == x[k])) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void backtrack(int t) {
		
		if (t > n) {
			sum++;
		} else {
			for (int i = 1; i <= n; i++) {
				x[t] = i;
				if (place(t)) {
					backtrack(t + 1);
				}
			}
		}
	}

}
