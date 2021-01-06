package com.example.ThreadPoolTest;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

//自定义线程池

/**
 * 固定大小
 */
public class MyThreadPool {
    private Thread[] threads;
    private BlockingQueue<Runnable> taskQueue;

    private static class worker extends Thread{
        private final BlockingQueue<Runnable> taskQueue;

        worker(BlockingQueue<Runnable> taskQueue) {
            this.taskQueue = taskQueue;
        }
        @Override
        public void run() {

                try {
                    while(!Thread.interrupted()) {
                    Runnable task = taskQueue.take();
                    task.run();
                    }
                } catch (InterruptedException e) {

                }
        }
    }

    public MyThreadPool(int nThreads) {
        threads = new Thread[nThreads];
        taskQueue = new LinkedBlockingQueue<Runnable>();

        //创建n个“工作线程”
        for (int i = 0; i < nThreads; i++) {
            Thread work = new worker(taskQueue);
            work.start();
            threads[i] = work;
        }

    }

    public void excute(Runnable task) throws InterruptedException {
    taskQueue.put(task);
    }

    public void shutdown() throws InterruptedException {
        for (Thread t :
                threads) {
            t.interrupt();
        }

        for (Thread t :
                threads) {
            t.join();
        }
    }
}
