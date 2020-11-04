package myQueue;

/**
 *@ClassName: myQueueNode
 *@Description 链表实现队列
 *@Author PandaChan1
 *@Date 2020/11/4
 *@Time 13:57
 */


class myQueueNode{
    public int val;
    public myQueueNode next;
    public myQueueNode(int value) {
        this.val = value;
    }
}
class queueOfListNode{
    //使用带尾节点的单链表
    public myQueueNode head;
    public myQueueNode tail;

    public void offer(int val) {  //入队
        myQueueNode node = new myQueueNode(val);
        if (isEmpty()) {
            this.head = node;
            this.tail = node;
        }else {
            this.tail.next = node;
            this.tail = node;
        }
    }

    public void poll() {  //出队，并删除
        if (isEmpty()) {
            System.out.println("队空，不能poll");
        }else {
            int temp = this.head.val;
            this.head = this.head.next;
            System.out.println(temp);
        }
    }

    public void peek() {  //出队，不删除
        if (isEmpty()) {
            System.out.println("队空，不能peek");
        }else {
            System.out.println(this.head.val);
        }

    }

    public boolean isEmpty() {  //判空
        if(this.head == null) {
            return true;
        }
        return false;
    }

    public void display() {
        myQueueNode cur = this.head;
        while(cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}

public class myQueueOfListNode {
    public static void main(String[] args) {
        queueOfListNode queue = new queueOfListNode();
        queue.offer(2);
        queue.offer(65);
        queue.offer(44);
        queue.offer(10);
        queue.offer(1);
        queue.display();
        System.out.println(queue.isEmpty());
        queue.peek();
        queue.display();
        queue.poll();
        queue.display();
    }
}
