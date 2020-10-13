package Code;

import java.util.Scanner;

/**
 *@ClassName: Code.flowerNumber
 *@Description 求水仙花数--》求1-9999 999999之间的自幂数
 *@Author PandaChan1
 *@Date 2020/10/13
 *@Time 10:35
 */



public class flowerNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入一个整数");
        int num = scanner.nextInt();
        scanner.close();
        for (int i = 1; i < num; i++) {
            //1、求输入的数的位数
            int count = 0;
            int temp = i;
            while(temp % 10 != 0) {
                count++;
                temp = temp / 10;
            }
            //2、取出各位上的数
            temp = i;
            int sum = 0;
            while(temp % 10 != 0) {
                sum += Math.pow(temp % 10,count);
                temp /= 10;
            }
            if ( sum == i) {
                System.out.println(i);
            }
        }
    }
    public static void main1(String[] args){
        for (int i = 0;i < 1000; i++) {
            int a = i % 10;
            int b = i /10 % 10;
            int c = i / 100;
            if (Math.pow(a,3)+Math.pow(b,3)+Math.pow(c,3) == i){
                System.out.println(i);
            }
        }
    }
}
