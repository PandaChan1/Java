package com.example;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
    public static void main(String[] args) throws InterruptedException {
//        TimerTask;  //让定时器去运行的任务
//        Timer;  //定时器

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("时间到了，该起床了");
            }

        };

        Timer timer = new Timer();
//        timer.schedule(task,5000);  //5秒后执行一次

        timer.scheduleAtFixedRate(task,5000,3000);  //5秒之后第一次，然后每3秒一次
        while(true) {
            System.out.println("我是主线程，我在睡觉");
            Thread.sleep(500);
        }

    }
}
