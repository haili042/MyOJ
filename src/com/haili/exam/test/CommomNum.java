package com.haili.exam.test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CommomNum {
	public static void main(String [] args) {
//		Scanner sc = new Scanner(System.in);
//		int n1 = sc.nextInt();
//		int [] arr1 = new int[n1];
//		for (int i = 0; i < n1; i++) {
//			arr1[i] = sc.nextInt();
//		}
//		int n2 = sc.nextInt();
//		int [] arr2 = new int[n2];
//		for (int i = 0; i < n2; i++) {
//			arr2[i] = sc.nextInt();
//		}
//		int n3 = sc.nextInt();
//		int [] arr3 = new int[n3];
//		for (int i = 0; i < n3; i++) {
//			arr3[i] = sc.nextInt();
//		}
//		
//		System.out.println(common(arr1,arr2,arr3));
		int [] arr1 = {1,9,30,2,7,10,94,64,82,13};
		int [] arr2 = {4,9,5,23,65,34,2,10,21};
		int [] arr3 = {10,97,47,38,82,91,2,71};
		System.out.println(common(arr1,arr2,arr3));
	}
	
	public static String common (int [] arr1, int [] arr2, int [] arr3) {
		String res = "";
		int min = arr1.length < arr2.length ? arr1.length : arr2.length, count = 0;
		min = min < arr3.length ? min : arr3.length;
		int[] resArr = new int[min];
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				for (int k = 0; k < arr3.length; k++) {
					if(arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
						resArr[count++] = arr1[i];
					} else {
						resArr[count++] = -100000;
					}
				}
			}
		}
		
		for (int i = resArr.length - 1; i > 0 ; i--) {
			for (int j = 0; j < i; j++) {
				if(resArr[j] > resArr[j+1]) {
					int temp = resArr[j];
					resArr[j] = resArr[j+1];
					resArr[j+1] = temp;
				}
			}
		}
		for (int i = 0; i < resArr.length; i++) {
			res += resArr[i] + " ";
		}
		
		return res;
	}
}
