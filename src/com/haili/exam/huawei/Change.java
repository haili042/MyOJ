package com.haili.exam.huawei;

import java.util.Scanner;




public class Change {

//	private static int[] coins = {2, 3, 5};
	
	private static int[] coins = {1, 5, 10, 20, 50, 100};
	
	public static void main(String[] args) {
		
//		Scanner sc = new Scanner(System.in);
//		System.out.println(change(1, 5));
//		System.out.println(change(4, 5));
		
//		System.out.println(minChange(11));
//		int[] arr = new int[12];
//		System.out.println(allCaseNum(11, arr));
		
//		test(0, 0);
//		test(1, -1);
//		test(2, 1);
//		test(3, 1);
//		test(4, 1);
//		test(5, 1);
//		test(6, 2);
		
		System.out.println(change(2));
		System.out.println(change(5));
//		change(5);
		
	}
	
	public static void test(int value, int expect) {
		int[] arr = new int[value+1];
		int result = allCaseNum(value, arr);
		System.out.println ("value : " + value + ", expect : " + expect + ", result : " + result + ", passed : " + (expect == result));
	}
	
	
	/**
	 * 
	 * 我们知道人民币有1、2、5、10、20、50、100这几种面值。
	 * 现在给你n(1≤n≤250)元，让你计算换成用上面这些面额表示且总数不超过100张，
	 * 共有几种。比如4元，能用4张1元、2张1元和1张2元、2张2元，三种表示方法。
	 * 
	 * 
	 * */
	public static int change(int value) {
		
		int[] arr = new int[value + 1]; // 保存通项结果
		arr[0] = 0;
		int[] counts = new int[value + 1];
		
		int minCoin = coins[0]; // 最小面值
		
		for (int i = minCoin; i <= value; i++) {
			
			int coin = i - minCoin;
			int minCoinNum = arr[coin];
			
			int count = 1;
			
			// 从面值第二项开始
			for (int j = 1; j < coins.length; j++) {
				int coinJ = i - coins[j];
				
				if (coinJ >= 0) {
					count ++;
				}
				if (coinJ >= 0 && arr[coinJ] < minCoinNum) {
					minCoinNum = arr[coinJ];
				} 
			}
			arr[i] = minCoinNum + 1;
			counts[i] = count;
			System.out.println( "value = " + i + ", needCoins = " + arr[i] + ", count = " + count);
		}
		
		return counts[value];
		
	}
	
	
	/**
	 * 
	 * 我们知道人民币有1、2、5、10、20、50、100这几种面值。
	 * 现在给你n(1≤n≤250)元，让你计算换成用上面这些面额表示且总数不超过100张，
	 * 求最少个数
	 * 
	 * 
	 * 用d(i)=j来表示凑够i元最少需要j个硬币
	 * 最少硬币, 通项公式: d(i)=min{ d(i-vj)+1 }，其中i-vj >=0，vj表示第j个硬币的面值;
	 * 
	 * */
	public static int minChange(int value) {

		int[] arr = new int[value + 1]; // 保存通项结果
		arr[0] = 0;
		
		int minCoin = coins[0]; // 最小面值
		
		for (int i = minCoin; i <= value; i++) {
			
			int coin = i - minCoin;
			int minCoinNum = arr[coin];
			
			int count = 1;
			
			// 从面值第二项开始
			for (int j = 1; j < coins.length; j++) {
				int coinJ = i - coins[j];
				
				if (coinJ >= 0) {
					count ++;
				}
				if (coinJ >= 0 && arr[coinJ] < minCoinNum) {
					minCoinNum = arr[coinJ];
				} 
			}
			arr[i] = minCoinNum + 1;
			System.out.println( "value = " + i + ", needCoins = " + arr[i] + ", count = " + count);
		}
		
		return arr[value];
	}
	
	
	/**
	 * 求所有可能的组合数
	 * */
	public static int allCaseNum(int value, int[] arr) {

		int minCoin = coins[0]; // 最小面值
		
		if (value == 0) {
			return 0;
		}
		if (value < minCoin) {
			arr[value] = -1;
			return -1;
		}
		if (value == minCoin) {
			arr[value] = 1;
			return 1;
		}
		
		
		int count = 0;
		
		
		// 从面值第二项开始
		for (int j = 1; 1 <= value / 2; j++) {
			
			int p1 = allCaseNum(value - j, arr), p2 = allCaseNum(j, arr);
			count += p1 + p2;
			arr[value] = count;
			
			if (arr[value - j] > 0 && arr[j] > 0) {
				
				
			} else {
				arr[value] = -1;
			}
		}
		
		return arr[value];
	}

}
