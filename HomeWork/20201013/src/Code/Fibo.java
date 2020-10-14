package Code;

import java.util.Scanner;

/**
 *@ClassName: Fibo
 *@Description 斐波那契数列的第n项
 *@Author PandaChan1
 *@Date 2020/10/13
 *@Time 19:49
 */


public class Fibo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个数字");
        int num = scanner.nextInt();
        scanner.close();
        System.out.println( fibo(num));
    }

    private  static int fibonacci(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        return fibonacci(n - 1)+ fibonacci(n - 2);
    }

    //循环迭代计算斐波那契数列比递归计算更快，避免冗余
    private static int fibo(int n) {
        int f1 = 1;
        int f2 = 1;
        int f3 = 1;
        for (int i = 3;i <= n; i++) {
            f3 = f1 + f2;
            //重新给f1 f2新值
            f2 = f1;
            f1 = f3;
        }
        return  f3;
    }

}
