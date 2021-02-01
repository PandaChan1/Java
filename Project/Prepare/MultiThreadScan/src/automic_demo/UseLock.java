package automic_demo;

public class UseLock {
        private static final int COUNT  = 1_0000_0000;
        private static int ai = 0;
        public static void main(String[] args) throws InterruptedException {
            Thread t1 = new Thread(() -> {
                for (int i = 0; i < COUNT; i++) {
                    synchronized (UseLock.class) {
                        ai++;
                    }
                }
            }) ;

            Thread t2 = new Thread(() -> {
                for (int i = 0; i < COUNT; i++) {
                    synchronized (UseLock.class) {
                        ai--;
                    }
                }
            });


            t1.start();
            t2.start();

            t1.join();
            t2.join();

            System.out.println(ai);
        }

}
