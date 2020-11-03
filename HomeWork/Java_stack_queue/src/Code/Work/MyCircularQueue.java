package Code.Work;

import java.util.Arrays;

/**
 *@ClassName: MyCircularQueue
 *@Description 设计循环队列
 *@Author PandaChan1
 *@Date 2020/11/3
 *@Time 11:30
 */


class cycleQueue {
    protected  int[] elem;
//    protected  int usedsize;
    protected  int front;
    protected  int rear;
    public cycleQueue(int k) {
        this.elem = new int[k];
    }


    public void enQueue(int val) {
        //判断是否为满
        if (isFull()) {
            System.out.println("队满，不能入队");
            return;
        }
        this.elem[this.rear] = val;
        this.rear = (this.rear + 1) % this.elem.length;
    }

    public void deQueue() {
        //是否为空
        if(isEmpty()) {
            System.out.println("队空，不能出队");
            return;
        }

        int temp = this.elem[this.front];
        this.front = (this.front + 1) % this.elem.length;
        System.out.println(temp);
    }
    //获得队头元素
    public int getFront(){
        if(isEmpty()) {
            return -1;
        }
        return this.elem[this.front];
    }
    //获得队尾元素
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        int index = this.rear == 0 ? this.elem.length - 1 : this.rear - 1;
        return this.elem[index];
    }

    public boolean isEmpty() {
if(this.rear == this.front) {
    return true;
}
return false;
    }

    public boolean isFull() {
        if((this.rear + 1)%this.elem.length == this.front) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "cycleQueue{" +
                "elem=" + Arrays.toString(elem) +
                ", front=" + front +
                ", rear=" + rear +
                '}';
    }
}
public class MyCircularQueue{
    public static void main(String[] args) {
        cycleQueue cycleQueue = new cycleQueue(5);
        cycleQueue.enQueue(77);
        cycleQueue.enQueue(2);
        cycleQueue.enQueue(13);
        cycleQueue.enQueue(6);
      cycleQueue.deQueue();
      cycleQueue.enQueue(99);

        System.out.println(cycleQueue.toString());
    }
}