public class myRunnable implements Runnable{
    @Override
    public void run() {
        while(true) {
            System.out.println("我是子线程");
        }
    }

    public static void main(String[] args) {
        Runnable runnable = new myRunnable();
        Thread thread = new Thread(runnable);
        thread.start();

        while (true) {
            System.out.println("我是父线程");
        }
    }
}
