package com.haili.exam.test;

/**
 * һ������, �ж��������Ʊ�ʾ��1�ĸ���
 * 
 * */

public class Bit1Num {

	public static void main(String[] args) {

		test(1, getBit1Num(1), 1);
		test(2, getBit1Num(2), 1);
		test(3, getBit1Num(3), 2);
		test(4, getBit1Num(4), 1);
		test(5, getBit1Num(5), 2);
		test(6, getBit1Num(6), 2);
		test(7, getBit1Num(7), 3);
		test(8, getBit1Num(8), 1);
		test(9, getBit1Num(9), 2);
		test(10, getBit1Num(10), 2);
		test(15, getBit1Num(15), 4);
		test(35, getBit1Num(35), 3);
		test(-1, getBit1Num(-1), 32);
		test(-2, getBit1Num(-2), 31);
	}
	
	public static void test(int m, int yours, int expect){
		System.out.println("num=" + m + ", yourResult=" + yours + ", expect=" + expect + ", " + (yours == expect));
	};
	
	/**
	 * 
	 * ���ַ����ٶȱȽϿ죬���������������n�Ĵ�С�޹أ�ֻ��n��1�ĸ����йء�
	 * ���n�Ķ����Ʊ�ʾ����k��1����ô�������ֻ��Ҫѭ��k�μ��ɡ�
	 * ��ԭ���ǲ������n�Ķ����Ʊ�ʾ�����ұߵ�1��ͬʱ�ۼӼ�������ֱ��nΪ0����������
	 * 
	 * Ϊʲôn &= (n �C 1)��������ұߵ�1�أ���Ϊ�Ӷ����ƵĽǶȽ���n�൱����n - 1�����λ����1��
	 * �ٸ����ӣ�8��1000��= 7��0111��+ 1��0001��������8 & 7 = ��1000��&��0111��= 0��0000���������8���ұߵ�1����ʵ�������λ��1��
	 * ��Ϊ8�Ķ�������ֻ��һ��1�����ٱ���7��0111��= 6��0110��+ 1��0001��������7 & 6 = ��0111��&��0110��= 6��0110����
	 * �����7�Ķ����Ʊ�ʾ�����ұߵ�1��Ҳ�������λ��1����
	 * 
	 * */
	
	public static int getBit1Num(int n) {
	    int res = 0 ;
	    
	    while (n != 0) {
	        n &= (n - 1) ; // ������λ��1
	        res++;
	    }
	    return res;
	}
	
	
	/**
	 * 
	 * �ʺ� > 0 �����
	 * */
	
	public static int getBit1Num2(int m) {
		int res = 0;
		int remain = m;
		
		while (remain != 0) {
			int n = getLog2N(remain);
			remain = remain - (int)Math.pow(2, n);
			res++;
		}
		return res;
	}
	
	public static int getLog2N (int up) {
		if (up == 0) { return 0; }
		return (int) (Math.log(up) / Math.log(2));
	}

}

