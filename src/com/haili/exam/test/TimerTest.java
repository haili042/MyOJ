/**
 * 
 */
package com.haili.exam.test;

import java.util.TimerTask;

import javax.management.timer.TimerMBean;

/**
 * @author Administrator
 *
 */
public class TimerTest extends TimerTask {

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	
	private String title;
	private String attr1;
	private String attr2;
	
	
	/**
	 * 
	 */
	public TimerTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param title
	 * @param attr1
	 * @param attr2
	 */
	public TimerTest(String title, String attr1, String attr2) {
		super();
		this.title = title;
		this.attr1 = attr1;
		this.attr2 = attr2;
	}

	@Override
	public void run() {
		System.out.println(this.getTitle());
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAttr1() {
		return attr1;
	}

	public void setAttr1(String attr1) {
		this.attr1 = attr1;
	}

	public String getAttr2() {
		return attr2;
	}

	public void setAttr2(String attr2) {
		this.attr2 = attr2;
	}
	
	

	
}
