package com.haili.exam.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LEDnumber {

	public static void main(String[] args) {
		List l1 = new ArrayList() {{
			add(1);
			add(2);
			add(3);
			add(4);
			add(5);
		}};
		List l2 = new ArrayList() {{
			add(2);
			add(3);
			add(6);
		}};
		System.out.println(l1.containsAll(l2));
		
		Scanner scr = new Scanner(System.in);
		int S = scr.nextInt();
		List list = null;

		for (int i = 0; i < S; i++) {
			int K = scr.nextInt();
			int N = scr.nextInt();

			System.out.println(K + " " + N);
			
			for (int j = 0; j < K; j++) {
				list = new ArrayList();
				String str = scr.nextLine();
				System.out.println(str.split(" ").toString());
				list.add(str.split(" "));
			}

		}
		System.out.println(list);

	}

	public static int led(List<Map> list) {
		Map map = new HashMap();
		Map num0 = new HashMap() {{
			 put(1, 1); 
			 put(2, 2); 
			 put(3, 3); 
			 put(5, 5); 
			 put(6, 6); 
			 put(7, 7); 
		}};
		Map num1 = new HashMap() {{
			 put(3, 3); 
			 put(6, 6); 
		}};
		Map num2 = new HashMap() {{
			put(1, 1); 
			put(3, 3); 
			put(4, 4); 
			put(5, 5); 
			put(7, 7); 
		}};
		Map num3 = new HashMap() {{
			put(1, 1); 
			put(3, 3); 
			put(4, 4); 
			put(6, 6); 
			put(7, 7); 
		}};
		Map num4 = new HashMap() {{
			put(2, 2); 
			put(3, 3); 
			put(4, 4); 
			put(6, 6); 
		}};
		Map num5 = new HashMap() {{
			put(1, 1); 
			put(2, 2); 
			put(3, 3); 
			put(4, 4); 
			put(5, 5); 
			put(6, 6); 
			put(7, 7); 
		}};
		Map num6 = new HashMap() {{
			put(1, 1); 
			put(2, 2); 
			put(4, 4); 
			put(6, 6); 
			put(7, 7); 
		}};
		Map num7 = new HashMap() {{
			put(1, 1); 
			put(3, 3); 
			put(6, 6); 
		}};
		Map num8 = new HashMap() {{
			put(1, 1); 
			put(2, 2); 
			put(3, 3); 
			put(4, 4); 
			put(5, 5); 
			put(6, 6); 
			put(7, 7); 
		}};
		Map num9 = new HashMap() {{
			put(1, 1); 
			put(2, 2); 
			put(3, 3); 
			put(4, 4); 
			put(6, 6); 
			put(7, 7); 
		}};
		
		map.put(0, num0);
		map.put(1, num1);
		map.put(2, num2);
		map.put(3, num3);
		map.put(4, num4);
		map.put(5, num5);
		map.put(6, num6);
		map.put(7, num7);
		map.put(8, num8);
		map.put(9, num9);
		
		for (Map m : list) {
			
		}
		
		return 0;
	}
}
