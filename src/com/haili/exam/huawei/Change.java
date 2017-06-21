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
	 * ����֪���������1��2��5��10��20��50��100�⼸����ֵ��
	 * ���ڸ���n(1��n��250)Ԫ��������㻻����������Щ����ʾ������������100�ţ�
	 * ���м��֡�����4Ԫ������4��1Ԫ��2��1Ԫ��1��2Ԫ��2��2Ԫ�����ֱ�ʾ������
	 * 
	 * 
	 * */
	public static int change(int value) {
		
		int[] arr = new int[value + 1]; // ����ͨ����
		arr[0] = 0;
		int[] counts = new int[value + 1];
		
		int minCoin = coins[0]; // ��С��ֵ
		
		for (int i = minCoin; i <= value; i++) {
			
			int coin = i - minCoin;
			int minCoinNum = arr[coin];
			
			int count = 1;
			
			// ����ֵ�ڶ��ʼ
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
	 * ����֪���������1��2��5��10��20��50��100�⼸����ֵ��
	 * ���ڸ���n(1��n��250)Ԫ��������㻻����������Щ����ʾ������������100�ţ�
	 * �����ٸ���
	 * 
	 * 
	 * ��d(i)=j����ʾ�չ�iԪ������Ҫj��Ӳ��
	 * ����Ӳ��, ͨ�ʽ: d(i)=min{ d(i-vj)+1 }������i-vj >=0��vj��ʾ��j��Ӳ�ҵ���ֵ;
	 * 
	 * */
	public static int minChange(int value) {

		int[] arr = new int[value + 1]; // ����ͨ����
		arr[0] = 0;
		
		int minCoin = coins[0]; // ��С��ֵ
		
		for (int i = minCoin; i <= value; i++) {
			
			int coin = i - minCoin;
			int minCoinNum = arr[coin];
			
			int count = 1;
			
			// ����ֵ�ڶ��ʼ
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
	 * �����п��ܵ������
	 * */
	public static int allCaseNum(int value, int[] arr) {

		int minCoin = coins[0]; // ��С��ֵ
		
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
		
		
		// ����ֵ�ڶ��ʼ
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
