package day1_14;

import java.util.Scanner;
/**
 *@ClassName: sum
 *@Description 数字各位之和 数字平方的各位之和
 *@Author PandaChan1
 *@Date 2021/1/14
 *@Time 17:25
 */


public class sum {
        public static void main(String[] args){
            Scanner sc=new Scanner(System.in);
            while(sc.hasNextInt()){
                int n=sc.nextInt();
                int n2=(int)Math.pow(n,2);
                String str1=String.valueOf(n);
                String str2=String.valueOf(n2);
                char[] ch1=str1.toCharArray();
                char[] ch2=str2.toCharArray();
                int sum1=0,sum2=0;
                for(int i=0;i<ch1.length;i++){
                    sum1+=Integer.parseInt(String.valueOf(ch1[i]));
                }
                for(int i=0;i<ch2.length;i++){
                    sum2+=Integer.parseInt(String.valueOf(ch2[i]));
                }
                System.out.println(sum1+" "+sum2);
            }
        }

}
