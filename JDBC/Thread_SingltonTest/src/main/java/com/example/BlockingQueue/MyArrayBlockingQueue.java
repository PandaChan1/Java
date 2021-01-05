package com.example.BlockingQueue;

public class MyArrayBlockingQueue {
    private Integer[] array = new Integer[100];
    private int size = 0;
    private int headindex = 0;  //队列中第一个元素的下标
    private int rearindex = 0;   //队尾，下一个可以放入元素的下标



    public synchronized boolean offer(Integer e) throws InterruptedException {
        while (size >= array.length) {
            wait();
        }

        //size一定小于array.length
        array[rearindex] = e;
        size++;
        rearindex++;
        if (rearindex == array.length) {
            rearindex = 0;
        }
        notify();

        return true;
    }

    public synchronized Integer poll() throws InterruptedException {
        while (size <= 0) {
            wait();
        }

        //size 一定大于0
        Integer e  = array[headindex];
        size--;
        headindex++;
        if (headindex == array.length) {
            headindex = 0;
        }

        notify();
        return e;
    }
}
