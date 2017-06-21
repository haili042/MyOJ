package com.haili.exam;

import java.util.Scanner;

public class Snack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner scanner = new Scanner(System.in);
//		snack(6);
		int[][] arr = new int[6][6];
		System.out.println(arr[3][5]);

		
	}
	
	public static void snack(int n) {
		
		int count = 0;
		int[][] arr = new int[n][n];
		int i = 0, j = 0;
		
		while (i < n && j < n) {
			int next = arr[i][j];
			
			if (next == 0) {
				i++;
			} else {
				i = 0;
			}
			
			if (i == 0 && j == 0) {
				i++;
			}
			if (i == n && j < n) {
				j++;
			}
			if (i == n) {
				i = 0;
				i++;
			} else {
				j++;
			}
			
			if (j == n) {
				j = 0;
				j++;
			} else {
				i++;
			}
			
			arr[i][j] = ++count;
			
		}
		
		for (int j2 = 0; j2 < arr.length; j2++) {
			for (int k = 0; k < arr.length; k++) {
				System.out.print(arr[j2][k] + " ");
			}
			System.out.println();
		}
		
	}

}
