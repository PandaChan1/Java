package com.company.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class allc {
    public static void main(String [] args){
        int start,end;
        Scanner sc=new Scanner(System.in);
            start=sc.nextInt();
            end=sc.nextInt();
            sc.close();
        System.out.println( solution(start,end));
    }
  private static int solution(int start, int end){
        int ans=0;
      Queue<Integer> queue=new LinkedList<>();
      for (int i=start;i<=end;i++){
          queue.offer(i);
      }
      int one=queue.poll();
      while (queue.size()!=0){
          if (one%3==0){
              ans++;
          }
          one=one*10+queue.poll();
      }

      return ans;

    }
}
