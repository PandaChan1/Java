public class ThreadInterruptTest {
    public static class myThread extends Thread{
        @Override
        public void run() {
            while(true) {
                System.out.println("Hello world");
                boolean interrupted = Thread.interrupted();
                if (interrupted) {  //判断状态
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new myThread();
        thread.start();
        Thread.sleep(5000);  //休眠5秒

       thread.interrupt();      //终止线程
    }

}
