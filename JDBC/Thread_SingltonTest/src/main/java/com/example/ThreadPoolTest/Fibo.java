package com.example.ThreadPoolTest;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Fibo {
    private static long fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    static class fibTask implements Runnable{
        private static int n;
        fibTask(int n) {
            this.n = n;
        }

        public void run() {
            long fib = fib(n);
            System.out.printf("fib(%d) = %d\n",n,fib);
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            fibTask fibTask = new fibTask(n);
            executorService.execute(fibTask);
        }

        executorService.shutdown();
    }
}
