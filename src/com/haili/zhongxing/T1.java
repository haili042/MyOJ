package com.haili.zhongxing;

public class T1 {

	public static void main(String[] args) {
		
		
		String s = "sdfsg";
		System.out.println(s.equals("sdfsgd"));

		TNode root = new TNode(4);
		root.left = new TNode(2);
		root.right = new TNode(6);
		root.left.left = new TNode(1);
		root.left.right = new TNode(3);
		root.right.left= new TNode(5);
		root.right.right = new TNode(8);
		root.right.right.left = new TNode(7);
		root.right.right.right = new TNode(9);
		
		TNode root2 = new TNode(8);
		root2.left = new TNode(7);
		root2.right = new TNode(9);
		
		System.out.println(isSubTree(root, root2));
	}
	
	public static int isSubTree(TNode root1, TNode root2) {
		
		StringBuffer sb1 = new StringBuffer("");
		if (root2.value > root1.value) {
			minOrder(root1.right, sb1);
		} else if (root2.value == root1.value) {
			minOrder(root1, sb1);
		} else {
			minOrder(root1.left, sb1);
		}
		
		StringBuffer sb2 = new StringBuffer("");
		minOrder(root2, sb2);
		
		String str1 = sb1.toString();
		String str2 = sb2.toString();
		if (str1.indexOf(str2) < 0 || root1.value == root1.value && str1 == str2) {
			return -1;
		} else {
			return 1;
		}
	}
	
	public static void minOrder(TNode root, StringBuffer str) {
		if (root != null) {
			minOrder(root.left, str);
			str.append(root.value);
			minOrder(root.right, str);
		}
	}

}

class TNode {
	public int value;
	TNode left;
	TNode right;
	
	public TNode(int value) {
		this.value = value;
		
	}
}
