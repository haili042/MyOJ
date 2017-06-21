package com.haili.tencent;

import java.util.Scanner;

public class T1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		while (in.hasNext()) {
			int num = in.nextInt();

			int res = 0;
			for (int i = 2; i <= num / 2; i++) {
				if (isZS(i) && isZS(num - i)) {
					res++;
				}
			}
			System.out.println(res);
		}

	}

	public static boolean isZS(int num) {
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
