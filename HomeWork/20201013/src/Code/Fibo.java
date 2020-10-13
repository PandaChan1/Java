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
        System.out.println( fibonacci(num));
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

}
