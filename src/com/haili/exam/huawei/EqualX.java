package com.haili.exam.huawei;

import java.util.ArrayList;  
import java.util.List;  
import java.util.Scanner;  
  
/** 
 *  
    �����⣺��ʽ�任 
    ����һ��������X��������ĵ�ʽ��ߵ�����֮�����+�Ż���-�ţ�ʹ�õ�ʽ������ 
    1 2 3 4 5 6 7 8 9 = X 
    ���磺 
    12-34+5-67+89 = 5 
    1+23+4-5+6-7-8-9 = 5 
    ���д����ͳ������������������������������ 
    ���룺       ����������ʽ�ұߵ����� 
    �����       ʹ�õ�ʽ�����ĸ��� 
    �������룺5 
    ���������21 
 * 
 */  
public class EqualX {  
    public static List<String> equals = new ArrayList<String>();  
    
    /** 
     *  
     * @param cur   ��ǰҪ������� 
     * @param x     ������Xֵ 
     * @param sum   �Ѿ��ۼӵ�ֵ   
     * @param temp  �ȴ��ۼӵ�ֵ 
     * @param equal �ȴ��ۼӵĵ�ʽ 
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
        //���ӷ���  
        equealX(cur + 1, x, sum, temp * 10 + cur, equal);  
        //��ӣ�  
        //ע��1ǰ��û�з���  
        if(equal != ""){
        	equealX(cur + 1, x, sum + temp, cur, equal + " + " + temp);  
        } else {
        	equealX(cur + 1, x, sum + temp, cur, equal + temp);  
        }
        //��ӣ�  
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

  
  
  
