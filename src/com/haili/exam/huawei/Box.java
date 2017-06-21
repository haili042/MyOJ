package com.haili.exam.huawei;

import java.util.Scanner;
import java.util.Stack;
 
public class Box
{
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext())
        {
            String input=scanner.nextLine();
            if(input!=null&&input.length()>0)
            {
                int countNum=0;
                Stack<Character> stack=new Stack<>();
                for(int i=0;i<input.length();i++)
                {
                    boolean flag=false;
                    switch (input.charAt(i))
                    {
                        case '(':
                            stack.push('(');
                            countNum++;
                            break;
                        case 'A':
                            System.out.println(countNum);
                            flag=true;
                            break;
                        case ')':
                            if(stack.peek()=='(')
                            {
                                stack.pop();
                            }
                            countNum--;
                            break;
                        default:
                            break;
                    }
                    if (flag)
                    {
                        break;
                    }
                }
            }
        }
        scanner.close();
    }
}
