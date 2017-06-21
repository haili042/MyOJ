package com.haili._360;

import java.util.Scanner;

/**
 * 
 * 1-n��������, �ж��ٸ��Ƕ����Ƶ���ʽ
 * 
 * case input 10 20
 * 
 * ouput 2 // 1-10 �� 1 10 ���Ƕ����� 3 // 1-20 �� 1 10 11 �Ƕ�����
 * 
 * 
 * */

public class T2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String str = sc.nextLine();
			int t = Integer.parseInt(str);
			System.out.println(getNum(t));
		}
	}

	public static int getNum(int n) {
		if (n <= 0)
			return 0;
		if (n < 10)
			return 1;
		int num = (int) Math.log10(n);
		int sum = 0;
		for (int i = 0; i < num; ++i)
			sum += Math.pow(2, i);
		if (n >= 10) {
			if (Math.floor(n / Math.pow(10, num)) > 1)
				sum += Math.pow(2, num);
			else {
				sum += getNum((int) (n % Math.pow(10, num))) + 1;
			}
		}
		return sum;
	}

}
