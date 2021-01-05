package com.example.ThreadPoolTest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {
    static class MyRunnable implements Runnable {
        public void run() {
            for (int i = 0; i < 10000000; i++) {
                System.out.println("hello");
            }
        }
    }
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,
                10,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10));

        threadPoolExecutor.execute(new MyRunnable());

        for (int i = 0; i < 10000000; i++) {
            System.out.println("world");
        }
    }
}
