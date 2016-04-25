package com.haili.exam.test;

import java.util.Scanner;

public class Back {  
  
    public static void main(String[] args) {  
//    	Scanner scan = new Scanner(System.in);
//    	String str = scan.next();
    	String s = "ccabbeafc";
        System.out.println(longestPalindrome (s));  
    }  
  
    // Á½¶ËËÑË÷
    public static int longestPalindrome1(String s) {  
  
        int maxPalinLength = 0;  
        String longestPalindrome = null;  
        int length = s.length();  
  
        // check all possible sub strings  
        for (int i = 0; i < length; i++) {  
            for (int j = i + 1; j < length; j++) {  
                int len = j - i;  
                String curr = s.substring(i, j + 1);  
                if (isPalindrome(curr)) {  
                    if (len > maxPalinLength) {  
                        longestPalindrome = curr;  
                        maxPalinLength = len;  
                    }  
                }  
            }  
        }  
        System.out.println(longestPalindrome);
        return longestPalindrome.length();  
    }  
  
    public static boolean isPalindrome(String s) {  
  
        for (int i = 0; i < s.length() - 1; i++) {  
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {  
                return false;  
            }  
        }  
  
        return true;  
    }  
    
    
    ///±©Á¦ËÑË÷·¢
    private static String longestPalindrome(String str){  
        if(str==""){  
            return "";  
        }  
        int n=str.length();  
        int maxLength=-1;  
        int beginIndex=0;  
        int endIndex=0;       
        for(int i=0;i<n;i++){  
            for(int j=i;j<n;j++){  
                int start=i;  
                int end=j;    
                boolean flag=true;  
                while(start<=end){                     
                    if(str.charAt(start)!=str.charAt(end)){  
                        flag=false;   
                        break;  
                    }  
                    start++;  
                    end--;  
                }  
                int tmpLength=j-i+1;  
                if(flag&&tmpLength>maxLength){  
                    maxLength=tmpLength;  
                    beginIndex=i;  
                    endIndex=j+1;  
                }  
            }  
        }  
        return str.substring(beginIndex,endIndex);  
    }    
}  