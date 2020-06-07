package com.company;

import java.util.Deque;
import java.util.LinkedList;

public class stacklearn {
    public static void main(String [] args){
        String hex=toHex(12500);
        if(hex.equalsIgnoreCase("30D4")){
            System.out.println("测试成功");
        }else{
            System.out.println("测试失败");
        }
    }
    static String toHex(int n){
        Deque<String> stack=new LinkedList<>();
        while(n!=0){
            stack.push(Integer.toHexString(n%16));
            n=n/16;
        }
        StringBuilder sb=new StringBuilder();
        for (String s:stack){
            sb.append(s);
        }
return sb.toString();
    }
}
