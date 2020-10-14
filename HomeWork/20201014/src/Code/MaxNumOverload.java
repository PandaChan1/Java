package Code;

import java.util.Scanner;

/**
 *@ClassName: MaxNumOverload
 *@Description 重载最大值方法，要求可以比较整数 浮点数的大小
 *@Author PandaChan1
 *@Date 2020/10/14
 *@Time 18:47
 */


public class MaxNumOverload {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入两个整数");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(maxTwoNum(a, b));
        System.out.println("输入两个小数");
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        System.out.println(maxTwoNum(x, y));
    }

    private static int maxTwoNum(int a, int b) {
        return a > b ? a : b ;
    }
    private static double maxTwoNum(double a, double b) {
        return a > b ? a : b ;
    }
}
