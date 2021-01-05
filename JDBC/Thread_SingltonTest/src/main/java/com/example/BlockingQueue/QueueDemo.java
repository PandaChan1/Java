package com.example.BlockingQueue;

public class QueueDemo {
     static MyArrayBlockingQueue queue  = new MyArrayBlockingQueue();

     static class 生产者 extends Thread{
         @Override
         public void run() {
             setName("生产者");
             while(true){
                 try {
                     queue.offer(1);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
         }
     }

     static class 消费者 extends  Thread{
         @Override
         public void run() {
             setName("消费者");
             while(true) {
                 try {
                     queue.poll();
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
         }
     }

    public static void main(String[] args) {

        for (int i = 0; i < 1; i++) {
            Thread 生产者 = new 生产者();
            生产者.start();
        }


        for (int i = 0; i < 50; i++) {
            Thread 消费者 = new 消费者();
            消费者.start();
        }

    }
}
