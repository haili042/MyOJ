package com.haili.exam.test;

/**
 * 一个整数, 判断它二进制表示的1的个数
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
	 * 这种方法速度比较快，其运算次数与输入n的大小无关，只与n中1的个数有关。
	 * 如果n的二进制表示中有k个1，那么这个方法只需要循环k次即可。
	 * 其原理是不断清除n的二进制表示中最右边的1，同时累加计数器，直至n为0，代码如下
	 * 
	 * 为什么n &= (n – 1)能清除最右边的1呢？因为从二进制的角度讲，n相当于在n - 1的最低位加上1。
	 * 举个例子，8（1000）= 7（0111）+ 1（0001），所以8 & 7 = （1000）&（0111）= 0（0000），清除了8最右边的1（其实就是最高位的1，
	 * 因为8的二进制中只有一个1）。再比如7（0111）= 6（0110）+ 1（0001），所以7 & 6 = （0111）&（0110）= 6（0110），
	 * 清除了7的二进制表示中最右边的1（也就是最低位的1）。
	 * 
	 * */
	
	public static int getBit1Num(int n) {
	    int res = 0 ;
	    
	    while (n != 0) {
	        n &= (n - 1) ; // 清除最低位的1
	        res++;
	    }
	    return res;
	}
	
	
	/**
	 * 
	 * 适合 > 0 的情况
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

