package Code;

import java.util.Scanner;

/**
 *@ClassName: SumOverload
 *@Description 重载方法，求两个整数的和，求三个小数的和
 *@Author PandaChan1
 *@Date 2020/10/14
 *@Time 18:55
 */


public class SumOverload {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入两个整数");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(add(a, b));
        System.out.println("请输入三个小数");
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        double z = sc.nextDouble();
        System.out.println(add(x, y, z));
    }

    private static double add(double x, double y, double z) {
        return x + y + z;
    }

    private static int add(int a, int b) {
        return a + b;
    }
   private static int add(int a, int b, int c) {
        return a + b + c;
   }
}
