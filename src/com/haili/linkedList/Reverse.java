package com.haili.linkedList;

import java.util.ArrayList;

/**
 * 链表反转
 * 
 * */

public class Reverse {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		
		ListNode node = ListNode.genListNode(arr);
//		reverse1(node);
		reverse2(node);
	}
	
	
	/** 方法1 新建链表 */
	public static ArrayList<Integer> reverse1(ListNode list) {
		ArrayList<Integer> result = new ArrayList<>();
		if (list == null) {
			return result;
		}

		ListNode newList = new ListNode(0);
		ListNode temp;

		/** 插入到新节点后面  */
		while (list.next != null) {
			System.out.print(list.next.val);
			temp = newList.next; // 保存 newList.next
			newList.next = list.next; // list[1] 放入  newList中
			list.next = list.next.next; // 删除 list[1]  这个点
			newList.next.next = temp;
		}

		System.out.println();
		
		newList = newList.next;
		while (newList != null) {
			result.add(newList.val);
			System.out.print(newList.val);
			newList = newList.next;
		}
		return result;
	}
	
	/** 
	 * 方法2
	 * 每次都将原第一个结点之后的那个结点放在list后面
	 * 
	 * 例如 head->1->2->3->4->null
	 * 为了反转这个单链表，我们先让头结点的next域指向结点2，
	 * 再让结点1的next域指向结点3，最后将结点2的next域指向结点1，
	 * 就完成了第一次交换，顺序就变成了Header-结点2-结点1-结点3-结点4-NULL，
	 * 然后进行相同的交换将结点3移动到结点2的前面，然后再将结点4移动到结点3的前面就完成了反转
	 *  */
	
	public static ArrayList<Integer> reverse2(ListNode list) {
		ArrayList<Integer> result = new ArrayList<>();
		if (list == null) {
			return result;
		}
		
		ListNode temp = list.next, p;
		
		while(temp.next != null) {
			p = temp.next;
			temp.next = p.next;
			p.next = list.next;
			list.next = p;
		}
		
		System.out.println();
		temp.next = new ListNode(list.val);
		while (list != null) {
			System.out.print(list.val);
			list = list.next;
		}
		return null;
	}

	
}
