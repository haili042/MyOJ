package com.haili.netease;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * ��������
 * 
 * {1,2,1} {15,78,78,15} {112} �ǻ�������
 * {1,2,2} {15,78,87,15} ���ǻ������� 
 * 
 * ���ڸ���һ������
 * ����ѡ�������������ڵ���, Ȼ���������ɾ����������, ���������������ĺ͵�֮ǰ��λ��
 * 
 * ��������Ҫ���ٴβ������Խ����ɻ�������
 * 
 * case
 * input
 * > 4 ���ٸ�����
 * > 1 1 1 3
 * 
 * output 
 * > 2
 * */

public class T3 {

	public static void main(String[] args) {

		// Scanner in = new Scanner(System.in);
		// int n = in.nextInt();
		// List<Integer> list = new ArrayList<>();
		// for (int i = 0; i < n; i++) {
		// list.add(in.nextInt());
		// }
		int[] arr = { 1, 1, 1, 3, 1, 1 };
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}
		System.out.println(t(list));

	}
	

	public static int t(List<Integer> list) {
		int minCount = 0;
		int maxCount = 0;
		
		List<Integer> list2 = new ArrayList<>();
		for (Integer i : list) {
			list2.add(i);
		}
		

		while (!isHw(list) && list.size() > 1) {
			int min = list.get(0) + list.get(1);
			int minIndex = 0;
			for (int i = 0; i < list.size() - 1; i++) {
				int s = list.get(i) + list.get(i + 1);
				if (s < min) {
					min = s;
					minIndex = i;
				} 
			}
			System.out.println("minindex: " + minIndex + ", min: " + min);
			list.set(minIndex, min);
			list.remove(minIndex + 1);
			minCount++;
		}
		
		while (!isHw(list2) && list2.size() > 1) {
			int max = 0;
			int maxIndex = 0;
			for (int i = 0; i < list2.size() - 1; i++) {
				int s = list2.get(i) + list2.get(i + 1);
				if (s > max) {
					max = s;
					maxIndex = i;
				}
			}
			list2.set(maxIndex, max);
			list2.remove(maxIndex + 1);
			maxCount++;
		}

		return Math.min(maxCount, minCount);
	}

	// �ж��Ƿ����
	public static boolean isHw(List<Integer> list) {
		int len = list.size();
		for (int i = 0; i < len; i++) {
			if (list.get(i) != list.get(len - i - 1)) {
				return false;
			}
		}
		return true;
	}

}
