package com.haili.linkedList;

import java.util.ArrayList;

/**
 * ����ת
 * 
 * */

public class Reverse {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		
		ListNode node = ListNode.genListNode(arr);
//		reverse1(node);
		reverse2(node);
	}
	
	
	/** ����1 �½����� */
	public static ArrayList<Integer> reverse1(ListNode list) {
		ArrayList<Integer> result = new ArrayList<>();
		if (list == null) {
			return result;
		}

		ListNode newList = new ListNode(0);
		ListNode temp;

		/** ���뵽�½ڵ����  */
		while (list.next != null) {
			System.out.print(list.next.val);
			temp = newList.next; // ���� newList.next
			newList.next = list.next; // list[1] ����  newList��
			list.next = list.next.next; // ɾ�� list[1]  �����
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
	 * ����2
	 * ÿ�ζ���ԭ��һ�����֮����Ǹ�������list����
	 * 
	 * ���� head->1->2->3->4->null
	 * Ϊ�˷�ת�����������������ͷ����next��ָ����2��
	 * ���ý��1��next��ָ����3����󽫽��2��next��ָ����1��
	 * ������˵�һ�ν�����˳��ͱ����Header-���2-���1-���3-���4-NULL��
	 * Ȼ�������ͬ�Ľ��������3�ƶ������2��ǰ�棬Ȼ���ٽ����4�ƶ������3��ǰ�������˷�ת
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
