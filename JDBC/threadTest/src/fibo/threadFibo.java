package fibo;

import java.util.Scanner;

public class threadFibo {

    private static int fib(int n) {
        if (n < 2) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }


   private static class MyThread extends Thread{
        private  final int n;
         MyThread(int n){
            this.n = n;
        }

        @Override
        public void run() {
            System.out.println(fib(n));
        }


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            Thread thread = new MyThread(n);
            thread.start();
        }
    }

}
