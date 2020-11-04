package myStack;
/**
 *@ClassName: myNode
 *@Description 链式栈
 *@Author PandaChan1
 *@Date 2020/11/4
 *@Time 13:55
 */


class myNode{
    public int val;
    public myNode next;
    public myNode(int value) {
        this.val = value;
    }
}
class stackOfListNode{
    public myNode head;  //头节点

    public void push(int value) {
        myNode node = new myNode(value);
    if (isEmpty()) {
        this.head = node;
    }else {
        node.next = this.head;
        this.head = node;
    }
    }

    public void pop() {
    if (isEmpty()) {
        System.out.println("栈空，无法pop");
    }else {
        System.out.println(this.head.val);
        this.head = this.head.next;
    }
    }

    public void peek() {
    if (isEmpty()) {
        System.out.println("栈空，无法peek");
    }else {
        System.out.println(this.head.val);
    }
    }

    public boolean isEmpty() {
     if(this.head == null) {
         return true;
     }
     return false;
    }

    public void display() {
        myNode cur = this.head;
        while(cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
public class myStackOfListNode {
    public static void main(String[] args) {
        stackOfListNode stack = new stackOfListNode();
        stack.push(2);
        stack.push(33);
        stack.push(25);
        stack.push(12);
        stack.push(99);
        stack.display();
        stack.peek();
        stack.display();
        stack.pop();
        stack.display();
        System.out.println(stack.isEmpty());
    }
}
