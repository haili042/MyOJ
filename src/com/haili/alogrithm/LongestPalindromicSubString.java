package com.haili.alogrithm;


/**
 * 求最长回文子串
 * */

public class LongestPalindromicSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1 = "xyyx";
		String s2 = "12xyyx";
		String s3 = "x";
		String s4 = "xyxkk";
		String s5 = "51233214";
		String s6 = "abaaab";
		System.out.println(longestPalindrome1(s1));
		System.out.println(longestPalindrome1(s2));
		System.out.println(longestPalindrome1(s3));
		System.out.println(longestPalindrome1(s4));
		System.out.println(longestPalindrome1(s5));
		System.out.println(longestPalindrome1(s6));
	}

	public static int longestPalindrome1(String s) {  
		  
        int max = 0;  
        int length = s.length();  
  
        // check all possible sub strings  
        for (int i = 0; i < length; i++) {  
            for (int j = i + 1; j < length; j++) {  
                int len = j - i;  
                String curr = s.substring(i, j + 1);  
                if (isPalindrome(curr)) {  
                    if (len > max) {  
                        max = len;  
                    }  
                }  
            }  
        }  
        return max + 1;
    }  
  
    public static boolean isPalindrome(String s) {  
  
        for (int i = 0; i < s.length() - 1; i++) {  
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {  
                return false;  
            }  
        }  
        return true;  
    }  
}

