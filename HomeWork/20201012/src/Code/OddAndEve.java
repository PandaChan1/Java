package Code;

import java.util.Scanner;
/**
 *@ClassName: OddAndEve
 *@Description 求一个整数中二进制的奇数位序列和偶数位序列
 *@Author PandaChan1
 *@Date 2020/10/13
 *@Time 12:05
 */


public class OddAndEve {



    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        System.out.println("请输入一个数");
        int num = scanner.nextInt();
        scanner.close();
        for (int i = 31; i >= 0;i-=2) {
            System.out.print(((num >> i) & 1)+" ");
        }
        System.out.println();
        for (int i = 30; i >= 0 ; i-=2) {
            System.out.print(((num >> i) & 1)+" ");
        }
    }

    public static void main1(String[] args) {
        int  res;
        Scanner sc = new Scanner(System.in);
        System.out.println("输入两个数字");
        int start = sc.nextInt();
        int end = sc.nextInt();
        res = sumOfFac(start,end);
        System.out.println(start+"到"+end+"的阶乘和为"+res);
    }
    public static int sumOfFac(int start,int end) {
        int sum=0;
        for (int i = start; i <= end; i++) {
            sum = sum + fac(i);
        }
        return sum;
    }
    public static int fac(int a) {
        int facNum=1;
        for (int i = 1;i <= a;i++ ) {
            facNum *= i;
        }
        return facNum;
    }
}
