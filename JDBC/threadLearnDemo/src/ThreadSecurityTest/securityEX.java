package ThreadSecurityTest;

public class securityEX {
    //COUNT越大正确率越低，因为调度次数越多
    private static final int COUNT = 10000;
    private static int n;

    private static class add extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < COUNT; i++) {
                n++;
            }
        }
    }

    private static class sub extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < COUNT; i++) {
                n--;
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new add();
        Thread t2 = new sub();

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(n);
    }
}
