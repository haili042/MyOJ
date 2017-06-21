package com.haili.linkedList;

public class ListNode {
	int val;
	ListNode next = null;
	
	ListNode(int val) {
		this.val = val;
	};
	
	public static ListNode genListNode (int[] arr) {
		
		ListNode pre = new ListNode(-1);
		ListNode res = pre;
		
		for (int i = 0; i < arr.length; i++) {
			pre.next = new ListNode(arr[i]);
			pre = pre.next;
		}
		
		return res;
	}
}
