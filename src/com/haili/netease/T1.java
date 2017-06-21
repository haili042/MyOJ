package com.haili.netease;

import java.util.Scanner;

/**
 * 反转数字 rev(123)=321 rev(100)=0 现在给出整数x和y, 求 rev(rev(x)+rev(y))
 * 
 * 
 * 
 * */
public class T1 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		while (in.hasNext()) {
			int x = in.nextInt();
			int y = in.nextInt();
			
			System.out.println(rev(rev(x) + rev(y)));
		}

	}

	public static int rev(int num) {
		int result = 0;
		while (true) {
			int n = num % 10;
			result = result * 10 + n;
			num = num / 10;
			if (num == 0) {
				break;
			}
		}
		return result;
	}

}
