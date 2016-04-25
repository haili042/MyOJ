package com.haili.exam.test;
import java.util.Scanner;

public class T3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
	}
	
	public static double timeCross(int x1, int y1, int x2, int y2) {
		double result = 0;
		result = Math.sqrt((x2- x1) * (x2- x1) + (y2 - y1) * (y2 - y1));
		return result;
	}

}
