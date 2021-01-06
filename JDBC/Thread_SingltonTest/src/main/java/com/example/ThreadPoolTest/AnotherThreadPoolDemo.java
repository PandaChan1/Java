package com.example.ThreadPoolTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AnotherThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();  //没有核心线程池，临时线程池大小无限大
        ExecutorService executorService1 = Executors.newFixedThreadPool(10);  //不允许出现临时线程池
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();   //单一线程的线程池
    }
}
