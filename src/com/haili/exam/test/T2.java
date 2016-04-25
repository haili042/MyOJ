package com.haili.exam.test;

import java.util.Scanner;

public class T2 {

	public static void main(String[] args) {
//		Scanner cin = new Scanner(System.in);
//        int p = cin.nextInt();
//        int n = cin.nextInt();
//        int [] arr = new int[n];
//        Scanner cin2 = new Scanner(System.in);
//        int count = 0;
//        for (int i = 0; i < n; i++) {
//    		Scanner scanner = new Scanner(System.in);
//    		arr[count++] = scanner.nextInt();
//		}
//        System.out.println(count(arr, 10));
		System.out.println(1^2^3^4^1);
	}
	
	public static int count(int [] arr, int p) {
		int count = 0;
		int [] old = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			old[i] = arr[i] % p;
			boolean flag = true;
			for (int j = 0; j < i; j++) {
				if (i != 0 && old[j] == (arr[i] % p)) {
					flag = false;
					break;
				}
			}
			if(flag) {
				count ++;
			}else {
				count ++;
				break;
			}
		}
		return count;
	}

}
