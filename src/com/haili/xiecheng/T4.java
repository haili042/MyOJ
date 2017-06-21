package com.haili.xiecheng;

public class T4 {

	public static void main(String[] args) {
		int[] arr = {3,2,8,7,9,5,6,4,0,1};
		int[] arr2 = {4,1,3,0,2,7,9,8,5,6};
		
		a(arr);
		a(arr2);
	}
	public static int a(int[] arr) {
		int res = 0;
		for (int i = 0; i < arr.length; i++) {
			res += Math.abs(arr[i] - i);
		}
		System.err.println(res);
		return res;
	}

}
