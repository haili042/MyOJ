package com.haili.tencent;

import java.util.BitSet;
import java.util.Scanner;

public class Geohash {

	private static int numbits = 6;

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		
		while (in.hasNext()) {
			int lon = in.nextInt();
			
			BitSet lonbits = bit(lon, -90, 90);
			StringBuilder buffer = new StringBuilder();
			for (int i = 0; i < numbits; i++) {
				buffer.append((lonbits.get(i)) ? '1' : '0');
			}
			
			System.out.println(buffer.toString());
		}

	}

	public static String encode(double lon) {
		BitSet lonbits = bit(lon, -90, 90);
		StringBuilder buffer = new StringBuilder();
		for (int i = 0; i < numbits; i++) {
			buffer.append((lonbits.get(i)) ? '1' : '0');
		}
		return buffer.toString();
	}

	private static BitSet bit(double lat, double floor, double ceiling) {
		BitSet buffer = new BitSet(numbits);
		for (int i = 0; i < numbits; i++) {
			double mid = (floor + ceiling) / 2;
			if (lat >= mid) {
				buffer.set(i);
				floor = mid;
			} else {
				ceiling = mid;
			}
		}
		return buffer;
	}

}