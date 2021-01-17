package day1_17;

import java.util.Scanner;

/**
 *@ClassName: percentage
 *@Description 年会抽奖 牛客   计算错排的概率
 *@Author PandaChan1
 *@Date 2021/1/17
 *@Time 15:45
 */


public class percentage {
        public static void main(String[] args){
            Scanner sc=new Scanner(System.in);
            while(sc.hasNext()){
                int n=sc.nextInt();
                float sum1=count(n);//每个人都不可能抽中出现的情况
                float sum2=factorial(n);//抽奖可能出现的情况
                float result=(sum1/sum2)*100;
                System.out.println(String.format("%.2f",result)+"%");
            }
        }
        public static float count(int n){
            if(n==1){
                return 0;
            }else if(n==2){
                return 1;
            }else{
                return (n-1)*(count(n-1)+count(n-2));
            }
        }
        public static float factorial(int num){
            float result=1;
            if(num==0){
                return 1;
            }else if(num>0){
                result=num*factorial(num-1);
            }
            return result;
        }
}
