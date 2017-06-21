package com.haili.exam.huawei;

import java.util.ArrayList;  
import java.util.List;  
import java.util.Scanner;  
  
/** 
 *  
    第三题：等式变换 
    输入一个正整数X，在下面的等式左边的数字之间添加+号或者-号，使得等式成立。 
    1 2 3 4 5 6 7 8 9 = X 
    比如： 
    12-34+5-67+89 = 5 
    1+23+4-5+6-7-8-9 = 5 
    请编写程序，统计满足输入整数的所有整数个数。 
    输入：       正整数，等式右边的数字 
    输出：       使该等式成立的个数 
    样例输入：5 
    样例输出：21 
 * 
 */  
public class EqualX {  
    public static List<String> equals = new ArrayList<String>();  
    
    /** 
     *  
     * @param cur   当前要处理的数 
     * @param x     给定的X值 
     * @param sum   已经累加的值   
     * @param temp  等待累加的值 
     * @param equal 等待累加的等式 
     */  
    public static void equealX(int cur,int x, int sum, int temp, String equal) {  
        if(cur == 10) {  
            if(sum + temp == x) {
            	equals.add(equal + " + " + temp + " = " + x);  
            	System.out.println(equals.toString());
            }
            if(sum - temp == x)  {
            	equals.add(equal + " - " + temp + " = " + x);  
            	System.out.println(equals.toString());
            }
            return;
        }  
        System.out.printf("cur: %d, sum: %d, temp: %s, equal: %s \n",cur, sum, temp, equal);
        //不加符号  
        equealX(cur + 1, x, sum, temp * 10 + cur, equal);  
        //添加＋  
        //注意1前面没有符号  
        if(equal != ""){
        	equealX(cur + 1, x, sum + temp, cur, equal + " + " + temp);  
        } else {
        	equealX(cur + 1, x, sum + temp, cur, equal + temp);  
        }
        //添加－  
        if(equal != "") {
        	equealX(cur + 1, x, sum - temp, cur, equal + " - " + temp);  
        }
    }  
    
    
    public static void main(String[] args) {  
        Scanner in = new Scanner(System.in);  
//        equealX(2, in.nextInt(), 0, 1, "");  
        t(2, in.nextInt(), 0, 1, "");  
        System.out.println("---------------------------------------------");
        System.out.println(equals.size());  
        for (int i = 0; i < equals.size(); i++) {  
            System.out.println(equals.get(i));  
        }  
    }
    
    public static void t(int cur, int x, int sum, int temp, String equal) {
    	if (cur == 10) {
    		if (sum + temp == x) {
    			equals.add(equal + " + " + temp + " = " + x);
    		}
    		if (sum - temp == x) {
    			equals.add(equal + " - " + temp + " = " + x);
    		}
    		return;
    	}
    	t(cur + 1, x, sum, temp * 10 + cur, equal);
    	if (!"".equals(equal)) {
    		t(cur + 1, x, sum + temp, cur, equal + " + " + temp);
    	} else {
    		t(cur + 1, x, sum + temp, cur, equal + temp);
    	}
    	
    	if (!"".equals(equal)) {
    		t(cur + 1, x, sum - temp, cur, equal + " - " + temp);
    	}
    	
    }
    
    
}  

  
  
  
