package com.haili.exam.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<User> users = new ArrayList<>();
		users.add(new User(1, 10));
		users.add(new User(3, 5));
		users.add(new User(5, 7));
		users.add(new User(2, 9));
		users.add(new User(6, 5));
		users.add(new User(2, 6));
		users.add(new User(2, 4));
		users.add(new User(3, 6));
		users.add(new User(5, 3));
		Collections.sort(users);
		System.out.println(users);
	}
	
	
}
class User implements Comparable<User>{
	
	int x;
	int y;

	public User(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "[x:" + this.x + ", y:" + this.y + "]";
	}
	
	@Override
	public int compareTo(User user) {
//		int i = this.x - user.x;
		int i = (int) (((float)user.y / user.x) - ((float)this.y / this.x));
		return i;
	}
	
}