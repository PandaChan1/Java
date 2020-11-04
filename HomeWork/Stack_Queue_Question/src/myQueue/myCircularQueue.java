package myQueue;

import java.util.Arrays;

/**
 *@ClassName: myCircularQueue
 *@Description 循环队列
 *@Author PandaChan1
 *@Date 2020/11/4
 *@Time 14:10
 */

class circularQueue{
    public int[] elem;
    public int front;
    public int rear;
    public circularQueue(int cap) {
        this.elem = new int[cap + 1]; //浪费一个空间，以便于判断队满和队空
    }

    public void enQueue(int value) {
    if (isFull()) {
        System.out.println("队满,不能入队");
    }else {
        this.elem[this.rear] = value;
        this.rear = (this.rear + 1) % this.elem.length;
    }
    }

    public void deQueue() {
    if (isEmpty()) {
        System.out.println("队空,不能出队");
    }else {
        System.out.println(this.elem[this.front]);
        this.front = (this.front + 1) % this.elem.length;
    }
    }


    public void getRear() {
    if (isEmpty()) {
        System.out.println("队空，不能getRear");
    }else {
        int index = this.rear == 0 ? this.elem.length - 1 : this.rear - 1;
        System.out.println(this.elem[index]);
    }
    }

    public void getFront() {
        if (isEmpty()) {
            System.out.println("队空，不能getFront");
        }else {
            System.out.println(this.elem[this.front]);
        }
    }

    public boolean isEmpty() {  //rear == front时队空
    if (this.rear == this.front) {
        return true;
    }
    return false;
    }

    public boolean isFull() {  //当（rear + 1） % this.elem.length == front时队满
     if ((this.rear + 1) % this.elem.length == this.front) {
         return true;
     }
     return false;
    }

    @Override
    public String toString() {
        return "circularQueue{" +
                "elem=" + Arrays.toString(elem) +
                '}';
    }
}



public class myCircularQueue {
    public static void main(String[] args) {
    circularQueue queue = new circularQueue(5);
    queue.enQueue(2);
    queue.enQueue(23);
    queue.enQueue(42);
    queue.enQueue(84);
        System.out.println(queue.toString());
        System.out.println(queue.isFull());
        queue.deQueue();
        queue.getFront();
        queue.getRear();
    }
}
