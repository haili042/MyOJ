package com.haili.toutiao;

public class T3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{9,2,4,3}, {1,50,6,8},{17,20,31,15}};
		
		T3 t = new T3();
		t.mySort(matrix);
	}
	
	public int[][] mySort(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		
		int len = m * n;
		int [] arr = new int[len];
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				arr[i*n+j] = matrix[i][j];
			}
		}
		
		int temp;
		for (int i = 0; i < len - 1; i++) {
			for (int j = 0; j < len - i - 1; j++) {
				if (arr[j] > arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i % 2 == 0) {
					matrix[i][j] = arr[i * n + j];
				} else {
					matrix[i][j] = arr[(i + 1) * n - j - 1];
				}
			}
		}
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		return matrix;
	}
	
	

}
