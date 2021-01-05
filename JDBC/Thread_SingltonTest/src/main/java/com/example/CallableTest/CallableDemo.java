package com.example.CallableTest;

import java.util.concurrent.*;

public class CallableDemo {
    static class MyCallable implements Callable<Integer> {
        private final int a;
        private final  int b;

        MyCallable(int a,int b) {
            this.a = a;
            this.b = b;
        }

        public Integer call() throws Exception {
            Thread.sleep(10000);
            return a + b;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,
                10,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10));

        Future<Integer> submit = threadPoolExecutor.submit(new MyCallable(10, 20));

        System.out.println("hello");
        Integer integer = submit.get();
        System.out.println("world");
        System.out.println(integer);

        threadPoolExecutor.shutdown();  //关闭线程池

    }
}
