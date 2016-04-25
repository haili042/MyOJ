package com.haili.exam.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class ThreadTest implements Runnable{

	private String name;
	
	public ThreadTest(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		System.out.println(this.name);
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public void getName(String name) {
		this.name = name;
	}
	
}

public class Test {
	
	public static void main(String [] args){
		Thread a = new Thread("A");
		Thread b = new Thread("B");
		Thread c = new Thread("C");
		
		for(int i = 0; i < 10; i++) {
			System.out.println(a.getName());
			System.out.println(b.getName());
			System.out.println(c.getName());
		}
		
	}
	
	
	public static int maxDimstion () {
		Scanner nsca = new Scanner(System.in);
		int n = nsca.nextInt();
		List<Map<String,Integer>> locations = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			Scanner scanner = new Scanner(System.in);

			Map<String,Integer> location = new HashMap<>();
			location.put("x", scanner.nextInt());
			location.put("y", scanner.nextInt());
			locations.add(location);
		}
		
		int maxX = 0;
		int minX = locations.get(0).get("x");
		int maxY = 0;
		int minY = locations.get(0).get("y");
		
		for (Map<String, Integer> location : locations) {
			if(maxX < location.get("x")) {
				maxX = location.get("x");
			}
			if(minX >= location.get("x")) {
				minX = location.get("x");
			}
			
			if(maxY < location.get("y")) {
				maxY = location.get("y");
			}
			if(minY >= location.get("y")) {
				minY = location.get("y");
			}
		}
		int lenght = (maxX - minX) > (maxY - minY) ? (maxX - minX) : (maxY - minY);
		return lenght*lenght;
	}
}
