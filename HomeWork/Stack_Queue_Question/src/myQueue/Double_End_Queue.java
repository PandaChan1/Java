package myQueue;

import java.util.Arrays;

/**
 *@ClassName: Double_End_Queue
 *@Description 循环双端队列
 *@Author PandaChan1
 *@Date 2020/11/4
 *@Time 14:37
 */

class double_queue {
    public int[] elem;
    public int front;
    public int rear;
    public double_queue(int cap) {
        this.elem = new int[cap];
    }

    public void addRear(int value) {  //队尾添加元素
        if (isFull()) {
            System.out.println("队满，不能addRear");
        }else {
            this.elem[this.rear] = value;
            this.rear = (this.rear + 1) % this.elem.length;
        }
    }

    public void addFront(int value) {  //队头添加元素
        if (isFull()) {
            System.out.println("队满，不能addFront");
        }else {
            this.front = this.front == 0 ? this.elem.length - 1 : this.front - 1;
            this.elem[this.front] = value;
        }
    }

    public void deleteRear() { //从队尾删除元素，并输出
        if (isEmpty()) {
            System.out.println("队空，无法deleteRear");
        }else {
            this.rear = this.rear == 0 ? this.elem.length - 1 : this.rear - 1;
            System.out.println(this.elem[this.rear]);
        }
    }

    public void deleteFront() {  //从队头删除元素，并输出删除了哪个元素
        if (isEmpty()) {
            System.out.println("队空，不能deleteFront");
        }else {
            int temp = this.elem[this.front];
            this.front = (this.front + 1 ) % this.elem.length;
            System.out.println(temp);
        }
    }


    public int getFront() {  //获取队头元素
        if (isEmpty()) {
            System.out.println("队空，不能getFront");
            return -1;
        }
        return this.elem[this.front];
    }

    public int getRear() {  //获取队尾元素
        if (isEmpty()) {
            System.out.println("队空，不能getRear");
            return -1;
        }
        int index = this.rear == 0 ? this.elem.length - 1 : this.rear - 1;
        return this.elem[index];
    }


    public boolean isEmpty() {  //判空
        if (this.front == this.rear) {
            return true;
        }
        return false;
    }

    public boolean isFull() {  //判满
        if ((this.rear + 1) % this.elem.length == this.front) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "double_queue{" +
                "elem=" + Arrays.toString(elem) +
                '}';
    }
}

public class Double_End_Queue {
    public static void main(String[] args) {
     double_queue queue = new double_queue(5);
     queue.addFront(1);
     queue.addFront(2);
     queue.addFront(3);
     queue.addRear(5);
        System.out.println(queue.toString());
        System.out.println(queue.isFull());
        queue.deleteRear();
        System.out.println(queue.toString());
        System.out.println(queue.getFront());
        System.out.println(queue.getRear());
    }
}
