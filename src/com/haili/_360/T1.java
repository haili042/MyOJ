package com.haili._360;

import java.util.Scanner;

/*
 * 
 * 
判断3*3数组是否是中心对称

case
input:
XX.
...
.XX
X.X
X..
...


output:
YES
NO

*/



public class T1 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		
		while (in.hasNext()) {
			String s1 = in.nextLine();
			String s2 = in.nextLine();
			String s3 = in.nextLine();
			
			
			String[][] matrix = new String[3][3];
			
			for (int i = 0; i < s1.length(); i++) {
				matrix[0][i] = s1.charAt(i) + "";
			}
			for (int i = 0; i < s2.length(); i++) {
				matrix[1][i] = s2.charAt(i) + "";
			}
			for (int i = 0; i < s3.length(); i++) {
				matrix[2][i] = s3.charAt(i) + "";
			}
			t(matrix);
		}
		
	}
	
	public static void t(String[][] matrix) {
		
		boolean flag = true;
		
		for (int i = 0; i < 3; i++) {
			
			if (!matrix[0][i].equals(matrix[2][2 - i])) {
				flag &= false;
			}
		}
		if (!matrix[1][0].equals(matrix[1][2])) {
			flag &= false;
		}
		
		String res = flag ? "YES" : "NO";
		System.out.println(res);
	}

}
