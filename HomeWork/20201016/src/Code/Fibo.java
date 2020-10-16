package Code;

import java.util.Scanner;
public class Fibo{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int res =0;
        long start=System.currentTimeMillis();
        res =fibo(n);
        long end = System.currentTimeMillis();
        System.out.println(res);
    }
    public static int fibo(int n) {
        if (n == 1 ) {
            return n;
        }
        if (n == 0) {
            return 0;
        }
        return fibo(n - 1) + fibo(n - 2);
    }

    public static int fibo1(int n) {
        int f1 = 1;
        int f2 = 1;
        if (n == 1 || n == 2) {
            return 1;
        }
        int f3 = 0;
        for (int i = 3;i <= n ;i++ ) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }
}