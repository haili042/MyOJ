package com.haili.exam.huawei;

import java.util.Scanner;

public class BigNum {

	
	public static void main(String[] args) {
		
//		Scanner sc = new Scanner(System.in);
		String num1 = "684131832";
		String num2 = "321535431";
		System.out.println(big(num1, num2));
	}
	
	public static int big(String s1, String s2) {
//		String s1 = String.valueOf(num1);
//		String s2 = String.valueOf(num2);
		int len1 = s1.length() - 1;
		int len2 = s2.length() - 1;
		int index = Math.max(len1, len2) + 2;
		int[] res = new int[index];
		int addUp = 0;
		
		while (index >= -1) {
			
			int p1 = Integer.parseInt(s1.charAt(len1--) + "");
			int p2 = Integer.parseInt(s2.charAt(len2--) + "");
			int s = p1 + p2 + addUp;
			
			res[index] = s;
			if (s >= 10) {
				addUp++;
				res[index] = s % 10;
			} else {
				res[index] = s;
			}
			index--;
			
		}
		System.out.println(res);
		
		return 0;
	}

}
