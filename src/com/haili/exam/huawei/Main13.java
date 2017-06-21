package com.haili.exam.huawei;

import java.util.Scanner;

public class Main13 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String str = in.nextLine();
			String[] sArray = str.split(",");
			System.out.print("[");
			for (int i = 0; i < sArray.length - 1; i++) {
				System.out.print("[");
				String[] svarr = sArray[i].split("=");
				System.out.print(svarr[0] + "," + svarr[1]);
				System.out.print("]" + ",");
			}
			System.out.print("[");
			String[] kvarr = sArray[sArray.length - 1].split("=");
			System.out.print(kvarr[0] + "," + kvarr[1]);
			System.out.print("]" + "]");
		}
	}
}
