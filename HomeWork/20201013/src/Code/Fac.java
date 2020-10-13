package Code;

import java.util.List;
import java.util.Scanner;

/**
 *@ClassName: Fac
 *@Description 前n项的阶乘和
 *@Author PandaChan1
 *@Date 2020/10/13
 *@Time 20:00
 */


public class Fac {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个数字");
        int num = scanner.nextInt();
        System.out.println(num + "的阶乘合为" + facAdd(num));
        System.out.println(num + "的阶乘为" + fac(num));
    }

    public static int facAdd(int n) {
        int  sum = 0;
        int fac = 1;
        for (int i = 1; i <= n; i++) {
            fac *= i;
            sum += fac;
        }
        return sum;
    }
    public static int fac(int n) {
        int fac = 1;
        for (int i = 1; i <= n; i++) {
            fac *= i;
        }
        return fac;
    }
}
