package day1_31;

import java.util.Scanner;

/**
 *@ClassName: Longest_MaxSum
 *@Description 数组的连续最大和  动态规划
 *@Author PandaChan1
 *@Date 2021/1/31
 *@Time 17:06
 */


public class Longest_MaxSum {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        String len2=scanner.nextLine();
        String str=scanner.nextLine();
        String[] s=str.split(" ");
        int len=s.length;
        int[] a=new int[len];
        for(int i=0;i<len;i++){
            a[i]=Integer.valueOf(s[i]);
        }
        int[] f=new int[len];
        int max= -2147483648;
        for(int i=0;i<len;i++){
            if(i==0){
                f[0]=a[0];
                if(max<f[0]) max=f[0];
                continue;
            }
            if(f[i-1]>0){
                f[i]=f[i-1]+a[i];
                if(max<f[i]) max=f[i];
            }else{
                f[i]=a[i];
                if(max<f[i]) max=f[i];
            }

        }

        System.out.println(max);
    }
}
