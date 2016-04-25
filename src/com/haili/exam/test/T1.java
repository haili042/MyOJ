package com.haili.exam.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class T1 {
	public static void main(String [] args) {
		Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int [] arr = new int[n];
        int count = 0;
        Scanner cin2 = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
        	arr[count++] = cin.nextInt();
		}
        System.out.println(max(arr));
	}
	
	public static int max(int [] arr) {
		int max = 0;
		if(arr.length == 1) {
			return arr[0];
		}
		if(arr.length == 2) {
			return arr[1] - arr[0];
		}
		int min = arr[2] - arr[0];
		
		for (int i = 0; i < arr.length - 1; i++) {
			
			if (max < arr[i+1] - arr[i]){
				max = arr[i+1] - arr[i];
			} 
			if (i < (arr.length - 2) && min > arr[i+2] - arr[i]) {
				min = arr[i+2] - arr[i];
			}
			
		}
		return max > min ? max :min;
	}
}
