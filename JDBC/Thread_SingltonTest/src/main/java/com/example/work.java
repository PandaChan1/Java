package com.example;

public class work {
    static class A implements Runnable {
        public void run() {
            System.out.println("1");
        }
    }
    static class B implements Runnable {
        public void run() {
            System.out.println("2");
        }
    }
    static class C implements Runnable {
        public void run() {
            System.out.println("3");
        }
    }
    static class D implements Runnable {
        public void run() {
            System.out.println("4");
        }
    }
    static class E implements Runnable {
        public void run() {
            System.out.println("5");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(new A());
        Thread b = new Thread(new B());
        Thread c = new Thread(new C());
        Thread d = new Thread(new D());
        Thread e = new Thread(new E());

        a.start();
        b.start();
        c.start();
        d.start();
        e.start();

        a.join();
        b.join();
        c.join();
        d.join();
        e.join();

        System.out.println("ok");
    }
}
