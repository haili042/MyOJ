package com.haili.xiecheng;

import java.util.Scanner;

public class T2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int num=sc.nextInt();
		int[] nArr=new int[num];
		for(int i=0;i<num;i++){
			nArr[i]=sc.nextInt();
		}
		int index=binarySearch(nArr, n);
		System.out.println(index);
//		int[] src = new int[] { 1, 3, 5, 7, 8, 9 };
//		System.out.println(binarySearch(src, 6));
	}

	/**
	 * * 二分查找算法 * *
	 * 
	 * @param srcArray
	 *            有序数组 *
	 * @param des
	 *            查找元素 *
	 * @return des的数组下标，没找到返回-1
	 */
	public static int binarySearch(int[] srcArray, int des) {

		int low = 0;
		int high = srcArray.length - 1;
		int middle=0;
		while (low <= high) {
			middle = (low + high) / 2;
			if (des == srcArray[middle]) {
				return middle;
			} else if (des < srcArray[middle]) {
				high = middle - 1;
			} else {
				low = middle + 1;
			}
		}
		return -1-low;
	}


}
