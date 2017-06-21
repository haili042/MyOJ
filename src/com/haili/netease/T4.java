package com.haili.netease;

import java.util.Scanner;

/**
 * 
 * �� һ�����Ķ����Ʊ�ʾ�� 1 �ĸ���Ϊ ������Ȩֵ
 * 
 * ��Ȩֵ��һ����N, �Ҵ���N����С��
 * 
 * case 
 * input 
 * 1717 
 * 1 
 * 2
 * 
 * output 
 * 1718 
 * 2 
 * 4
 * 
 * */
public class T4 {

	public static void main(String[] args) {
		// t(512);
		// t(30); // 30(11110) 39(100111)
		// t(31); // 31(11111) 47(101111)
		// t(22); // 22(10110) 25(11001)
		// t(1); // 1(1) 2(10) 
		// t(2); // 2(10) 4(100)
		// t(3); // 3(11) 5(101)

		Scanner in = new Scanner(System.in);

		while (in.hasNext()) {
			int n = in.nextInt();
			t(n);
		}
	}

	// ����1, ���ķ���
	public static void t(int n) {
		String bit = Integer.toBinaryString(n);
		int len = bit.length();
		String[] bitArr = bit.split("");
		bitArr[0] = "0";
		for (int i = len; i > 0; i--) {
			String cur = bitArr[i]; // ��ǰ
			String pre = bitArr[i - 1]; // ǰһ��
			
			if ("1".equals(cur)) {
				String temp;
				
				if ("0".equals(pre)) {
					// ��ǰ��1, ǰһ����0, �����˳�
					temp = bitArr[i];
					bitArr[i] = bitArr[i - 1];
					bitArr[i - 1] = temp;
					break;
				} else {
					temp = bitArr[i];
					// �������� 1, ƽ��, �� 1100 -> 1001 
					// 011100 -> 011001 -> 010011 -> 100011
					for (int j = i; j <= len; j++) {
						bitArr[j - 1] = bitArr[j];
					}
					bitArr[len] = temp;
				}
			}
		}

		String res = "";
		for (int i = 0; i < bitArr.length; i++) {
			res += bitArr[i];
		}

		System.out.println(Integer.valueOf(res, 2));
	}

	// ����2, ����
	public static void tt(int n) {
		int oneCount = one(n);
		int last = -1;
		while (last != oneCount) {
			last = one(++n);
		}
		System.out.println(n);
	}

	// 1 count
	public static int one(int n) {
		int res = 0;
		while (n > 0) {
			res += n & 0X01;
			n >>= 1;
		}
		return res;
	}

}
