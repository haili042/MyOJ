package com.haili.exam.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Apple {
	public static void main(String[] args) {
		
//		Scanner nsca = new Scanner(System.in);
//		int n = nsca.nextInt();
		int n = 5;
		System.out.println(apple(n));
	}
	
	public static int apple(int n) {
		
		if(n == 2) {
			return 3;
		}
		return apple(n-1) * n / (n - 1) + 1;
		
	}
	
	
}
