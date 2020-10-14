package Code;

import java.util.Scanner;

public class Fibonaci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要求的第几项斐波那契");
        int num = sc.nextInt();
        System.out.println(fibo(num));
    }

    private static int fibo(int num) {
        if (num == 1 || num == 2) {
            return 1;
        }
        return fibo(num - 1) + fibo(num - 2);
    }

}
