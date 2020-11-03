package Code.Work;

import java.util.LinkedList;
import java.util.Queue;

class Node{
    protected int val;
    protected Node next;
    public Node(int val){
        this.val = val;
    }
}

/**
 *@ClassName: myQueue
 *@Description 链式队列
 *@Author PandaChan1
 *@Date 2020/11/3
 *@Time 11:24
 */


class myQueue{
    protected Node head;
    protected Node tail;

    public void offer(int val){
        Node node = new Node(val);
        if (this.tail == null) {
            this.tail = node;
            this.head = node;
            return;
        }
        this.tail.next = node;
        this.tail = node;
    }

    public int poll() {
        if (isEmpty()) {
            System.out.println("队空，不能pop");
            return -1;
        }
        int temp = this.head.val;
        if(this.head.next == null) {//只有一个元素
            this.head = null;
            this.tail = null;
            return temp;
        }
        this.head = this.head.next;
        return temp;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("队空，不能peek");
            return -1;
        }
        return this.head.val;
    }

    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        }
        return false;
    }
}
public class QueueTest {
    public static void main(String[] args) {
        myQueue myQueue = new myQueue();
        myQueue.offer(2);
//        myQueue.offer(5);
//        myQueue.offer(19);
//        myQueue.offer(95);
//        myQueue.offer(82);

        System.out.println(myQueue.poll());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.isEmpty());

    }
}
