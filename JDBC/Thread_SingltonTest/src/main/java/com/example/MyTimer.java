package com.example;

public class MyTimer {

    static abstract class TimerTask{
        protected abstract void run();
    }

    static class Timer {
        public void schedule(final TimerTask task, final long delay) {
            Thread thread = new Thread(){
                @Override
                public void run() {
                    try {
                        Thread.sleep(delay);
                        task.run();
                    } catch (InterruptedException e) {

                    }
                }
            };
            thread.start();
        }
    }

    public static void main(String[] args) throws InterruptedException {
   Timer timer = new Timer();
   timer.schedule(new TimerTask() {
       @Override
       protected void run() {
           System.out.println("该起床了");
       }
   },5000);

   while(true) {
       System.out.println("我是主线程，我在睡觉");
       Thread.sleep(500);
   }
    }
}
