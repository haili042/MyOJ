package com.haili.leshi;

import java.util.Scanner;

public class T1 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			int n = in.nextInt();
			int m = in.nextInt();
			
			System.out.println(t(n, m));
		}
		
//		System.out.println(t(3310, 1033));
//		System.out.println(t(4, 5));
	}

	public static String t(int n, int m) {

		String[] s = (n + "").split("");
		int[] arr = new int[s.length-1];
		for (int i = 1; i < s.length; i++) {
			arr[i-1] = Integer.parseInt(s[i]);
		}

		int temp = 0;
		for (int i = 1; i < arr.length; i++) {
			int j = i - 1;
			temp = arr[i];
			// ÍùºóÎ»ÒÆ
			for (; j >= 0 && temp < arr[j]; j--) {
				arr[j + 1] = arr[j];
			}
			arr[j + 1] = temp;
		}
		
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				index = i;
				break;
			}
		}
		temp = arr[index];
		arr[index] = arr[0];
		arr[0] = temp;
		
		String ns = "";
		
		for (int i = 0; i < arr.length; i++) {
			ns += arr[i];
		}
		String res = ns.equals(m + "") ? "yes" : "no";
		return res;
	}

}
