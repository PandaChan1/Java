package Code;

import java.util.Scanner;

/**
 *@ClassName: Fac
 *@Description 递归求数的阶乘
 *@Author PandaChan1
 *@Date 2020/10/14
 *@Time 19:21
 */


public class Fac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数字");
        int num = sc.nextInt();
        System.out.println(fac(num));
    }

    private static int fac(int num) {
        if (num == 1) {
            return 1;
        }
        if (num == 0 || num < 0) {
            return 0;
        }
        return fac(num-1)*num;
    }

}
