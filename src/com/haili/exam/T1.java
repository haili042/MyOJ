package com.haili.exam;

import java.util.Scanner;

public class T1 {

	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		int x1, y1, x2, y2;
		while (cin.hasNextInt()) {
			x1 = cin.nextInt();
			y1 = cin.nextInt();
			x2 = cin.nextInt();
			y2 = cin.nextInt();
			double dist = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1)
					* (y2 - y1));
			String result = String.format("%.2f", dist);
			System.out.println(result);
		}
	}
}
