package com.haili.exam.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class T1 {
	
	public static void main(String[] args) {
		String s = "-,+,a,*,+,b,c,d,e,";
		String s2 = "+,a,b,";
		String s3 = "*,+,a,b,+,c,d";
		T1 t = new T1();
//		System.out.println(t.t1(s.split(",")));
//		System.out.println(t.t1(s2.split(",")));
		System.out.println(t.t1(s3.split(",")));
	}
	
	public T1() {}
	
	public String t1(String[] ss) {
		
		Map m = new HashMap<>();
		m.put("+", 0);
		m.put("-", 0);
		m.put("*", 0);
		m.put("/", 0);
		
		Queue<String> queue = new LinkedBlockingQueue<>();
		Stack<String> stack = new Stack<>();
		
		String[] mid = new String[ss.length];
		
		String last = "";
		String midS = "";
		
		
		for (int i = 0; i < ss.length; i++) {
			String s = ss[i];
			
			if (m.get(s) == null) {
				
				
				if (stack.size() > 0 && last != "") {
					
					String s3 = stack.pop();
					
					if (stack.size() > 0) {
						midS = midS + last + s + s3;
					} else {
						midS = last + midS + s  +s3;
					}
				}
				last = s;
			} else {
				stack.push(s);
			}
		}
		
		String res = "";
		for (int i = 0; i < midS.length(); i++) {
			res += midS.charAt(i) + ",";
		}
		return res;
	}
	
}
