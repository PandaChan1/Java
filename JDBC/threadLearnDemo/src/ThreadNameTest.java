public class ThreadNameTest {
    public static class myThreadName extends Thread{
        myThreadName(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(10_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread a = new myThreadName("张三");
        Thread b = new myThreadName("李四");
        Thread c = new myThreadName("王五");

        a.start();
        b.start();
        c.start();

    }
}
