package ControlThread;

public class ControlThreadExcuteSequence {
    private static String signal;

    static class A extends Thread{
        @Override
        public void run() {
            while(true) {
                synchronized (ControlThreadExcuteSequence.class){
                    if ("A".equals(signal)) {
                        break;
                    }
                }
            }
            System.out.println("A线程运行");
            signal = "B";
        }
    }

    static class B extends Thread{
        @Override
        public void run() {
            while(true) {
                synchronized (ControlThreadExcuteSequence.class){
                    if ("B".equals(signal)) {
                        break;
                    }
                }
            }
            System.out.println("B线程运行");
            signal = "C";
        }
    }

    static class C extends Thread{
        @Override
        public void run() {
            while(true) {
                synchronized (ControlThreadExcuteSequence.class){
                    if ("C".equals(signal)) {
                        break;
                    }
                }
            }
            System.out.println("C线程运行");
            signal = "A";
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread A = new A();
        Thread B = new B();
        Thread C = new C();
        signal = "C";

        A.start();
        Thread.sleep(2000);
        B.start();
        Thread.sleep(2000);
        C.start();
    }


}
