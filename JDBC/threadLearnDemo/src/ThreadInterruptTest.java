public class ThreadInterruptTest {
    public static class myThread extends Thread{
        @Override
        public void run() {
            while(true) {

                try{
                    Thread.sleep(10 * 1000);
                }catch (InterruptedException e){
//                    break;
                    System.out.println("出现异常");
                }
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
