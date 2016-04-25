package com.haili.exam.test;

public class SwitchStatus extends Thread {
	private static String th = "A";
	private static byte[] lock = new byte[0];
	private String name = "";
	private int count = 10;
	public SwitchStatus(String name) {
		this.name = name; 
	}
	public void run() {
		while (count > 0) {
			synchronized (lock) {
				if (th.equals(this.name)) {
					System.out.println(name);
					count--;
					if (th.equals("A")) {
						th = "B";
					} else if (th.equals("B")) {
						th = "C";
					} else if (th.equals("C")) {
						th = "A";
					}
				}
			}
		}
	}
	public static void main(String[] args) { 
		(new SwitchStatus("A")).start();
		(new SwitchStatus("B")).start();
		(new SwitchStatus("C")).start();
	}
}