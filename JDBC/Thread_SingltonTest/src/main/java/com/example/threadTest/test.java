package com.example.threadTest;

public class test {
    public static void main(String[] args) {

        Thread t = new Thread(new Runnable() {

            public void run() {
                System.out.println("1");
            }
        });

        t.start();

        System.out.println("2");

    }
}
