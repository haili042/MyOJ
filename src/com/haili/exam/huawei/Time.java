package com.haili.exam.huawei;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Time {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		while (scanner.hasNext()) {
			String time = scanner.nextLine();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			
			Calendar c = Calendar.getInstance();
			try {
				c.setTime(sdf.parse(time));
				c.add(Calendar.SECOND, 1);
				String res = sdf.format(c.getTime());
				System.out.println(res);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}
}