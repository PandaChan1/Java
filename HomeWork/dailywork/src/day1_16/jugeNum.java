package day1_16;

import java.util.Scanner;

/**
 *@ClassName: jugeNum
 *@Description 判断守形数  即一个数的平方的后几位与原数字相同 如25  625以25结尾 6 36以6结尾
 *@Author PandaChan1
 *@Date 2021/1/16
 *@Time 17:29
 */


public class jugeNum {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            if(String.valueOf(n*n).endsWith(String.valueOf(n))){
                System.out.println("Yes!");
            }else{
                System.out.println("No!");
            }
        }
    }
}
