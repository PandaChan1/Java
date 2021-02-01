package automic_demo;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {
    private static final int COUNT  = 1_0000_0000;
    private static final AtomicInteger ai = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {
    Thread t1 = new Thread(() -> {
        for (int i = 0; i < COUNT; i++) {
            ai.getAndIncrement();
        }
    }) ;

    Thread t2 = new Thread(() -> {
            for (int i = 0; i < COUNT; i++) {
                ai.getAndDecrement();
            }
    });


    t1.start();
    t2.start();

    t1.join();
    t2.join();

        System.out.println(ai.get());
    }




}
