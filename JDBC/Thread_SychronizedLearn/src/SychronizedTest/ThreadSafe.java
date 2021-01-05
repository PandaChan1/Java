package SychronizedTest;

public class ThreadSafe {
     private static final int COUNT = 10_000;
     private static int n = 0;

     static class adder extends Thread{
         @Override
         public void run() {
             synchronized (adder.class) {   //加的哪把锁不重要，重要的是加的同一把锁
                 for (int i = 0; i < COUNT; i++) {
                     n++;
                 }
             }
         }
     }

     static class suber extends Thread{
         @Override
         public void run() {
             for (int i = 0; i < COUNT; i++) {
                 synchronized (adder.class) {  //加同一把锁
                     n--;
                 }
             }
         }
     }

    public static void main(String[] args) throws InterruptedException {
        Thread add = new adder();
        Thread sub = new suber();

        add.start();
        sub.start();

        add.join();
        sub.join();

        System.out.println(n);
    }
}
