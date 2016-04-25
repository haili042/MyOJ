package com.haili.exam.test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;


/**
 * Hello world!
 *
 */
public class Main {
	public static void main(String[] args) {		
		
		Scanner sysIn = new Scanner(System.in);
		
		
		
		List<Map<String,Object>> list = new ArrayList<>();
		Map<String,Object> m1 = new HashMap<>();
		m1.put("id", "123");
		String [] m1have = {"1001","1002"};
		m1.put("have", m1have);
		m1.put("want", "1003");
		m1.put("visited", false);
		list.add(m1);
		
		Map<String,Object> m2 = new HashMap<>();
		String [] m2have = {"1001"};
		m2.put("id", "127");
		m2.put("have", m2have);
		m2.put("want", "1010");
		m2.put("visited", false);
		list.add(m2);

		
		Map<String,Object> m3 = new HashMap<>();
		String [] m3have = {"1010"};
		m3.put("id", "128");
		m3.put("have", m3have);
		m3.put("want", "");
		m3.put("visited", false);

		list.add(m3);

		
		
		Map<String,Object> m4 = new HashMap<>();
		m4.put("id", "129");
		String [] m4have = {};
		m4.put("have", m4have);
		m4.put("want", "");
		m4.put("visited", false);

		list.add(m4);

		
		Map<String,Object> m5 = new HashMap<>();
		m5.put("id", "124");
		String [] m5have = {"1007"};
		m5.put("have", m5have);
		m5.put("want", "1003");
		m5.put("visited", false);

		list.add(m5);

		
		Map<String,Object> m6 = new HashMap<>();
		m6.put("id", "125");
		String [] m6have = {"1003"};
		m6.put("have", m6have);
		m6.put("want", "1004");
		m6.put("visited", false);

		list.add(m6);

		
		Map<String,Object> m7 = new HashMap<>();
		m7.put("id", "126");
		String [] m7have = {"1004"};
		m7.put("have", m7have);
		m7.put("want", "1002");
		m7.put("visited", false);

		list.add(m7);

//		System.out.println(getByWant(list, "1003"));
		
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			
			has(list, list.get(i), count);
		}

	}
	
	public static boolean has(List<Map<String,Object>> list, Map<String,Object> m, int count) {
		m.put("visited", true);
		List<Map<String,Object>> byWant = getByWant(list, (String)m.get("want"));
		if(byWant.size() <= 0) {
			System.out.println(count);
			return false;
		} else {
			count ++;
			for (int i = 0; i < byWant.size(); i++) {
				has(list, byWant.get(i) , count);
			}
		}
		return true;
		
	}
	
	public static List<Map<String,Object>> getByWant (List<Map<String,Object>> list, String wantKey) {
		List<Map<String,Object>> res = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < ((String [])list.get(i).get("have")).length; j++) {
				if (((String [])list.get(i).get("have"))[j].equals(wantKey)) {
					res.add(list.get(i));
				}
			}
		}
		return res;
	}
   
}