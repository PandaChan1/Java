package com.company.leetcode;

import java.util.ArrayList;
import java.util.Scanner;

public class coder {
    public  static void main(String[] args){
        int [] nums=new int[4];
        Scanner scanner=new Scanner(System.in);
        System.out.println("输入4个数字");
        for (int i=0;i<nums.length;i++) {
            nums[i]=scanner.nextInt();
        }
        scanner.close();
        for (int i:solution(nums)){
            System.out.print(i+" ");
        }
        System.out.println();
        for (int i:solutionTwo(nums)){
            System.out.print(i+" ");
        }
    }
   private static int[] solution(int [] nums){
        ArrayList<Integer> arrayList=new ArrayList<>();

        for (int i=0;i<(nums.length)/2;i++){  //成对出现，遍历一半
            for (int j=0;j<nums[i*2];j++){   //每个数出现的次数
                arrayList.add(nums[i*2+1]);
            }
        }
        int [] ans = new int[arrayList.size()];
        for (int m=0;m<arrayList.size();m++){
            ans[m]=arrayList.get(m);
        }
        return ans;
   }

   private  static int[] solutionTwo(int [] nums){
        int len=0;
        //偶数位相加就是新数组长度
        for (int i=0;i<nums.length;i+=2){
            len+=nums[i];
        }
        int [] ans=new int[len];
        int index=0; //新数组下标
        for (int i=0;i<nums.length;i+=2){
            int a=nums[i];
            while (a>0){
                ans[index]=nums[i+1];
                a--;
                index++;
            }
        }
        return ans;
   }
}
