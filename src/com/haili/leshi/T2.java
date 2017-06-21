package com.haili.leshi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
1000 1050
1000 1020 50
1000 1030 70
1020 1030 15
1020 1040 30
1030 1050 40
1040 1050 20
*/

public class T2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		
		Map<Integer, List<Package>> map = new HashMap<>();
		List<Package> list = new ArrayList<>();
		
		int nn = 5;
		while(in.hasNext() && nn-- > 0) {
			int oldv = in.nextInt();
			int newv = in.nextInt();
			int size = in.nextInt();
			
			if (map.get(oldv) != null) {
				map.get(oldv).add(new Package(oldv, newv, size));
			} else {
				List<Package> l = new ArrayList<>();
				l.add(new Package(oldv, newv, size));
				map.put(oldv, l);
			}
		}
		t(map, m, n);
	}
	
	public static void t(Map<Integer, List<Package>> map, int m, int n) {
		int min = 0;
		
		for (Integer key : map.keySet()) {
			
			if (key == m) {
				List<Package> list = map.get(key);
				
				System.out.println(key);
				for (Package p : list) {
					
					if (p.newv == n) {
						
					} else if (map.get(p.newv) != null) {
						System.out.println(p.newv);
					}
				}
				
			}
			
		}
		
	}

}
class Package {
	int oldv;
	int newv;
	int size;
	
	public Package(int oldv, int newv, int size) {
		this.oldv = oldv;
		this.newv = newv;
		this.size = size;
	}

	@Override
	public String toString() {
		return "Package [oldv=" + oldv + ", newv=" + newv + ", size=" + size
				+ "]";
	}
	
}
