import java.util.Stack;

/**
 *@ClassName: Queue_use_stack
 *@Description 栈实现队列
 *@Author PandaChan1
 *@Date 2020/11/4
 *@Time 18:47
 */

class queue_with_stack{
    Stack<Integer> s1;  //只入队
    Stack<Integer> s2;  //只出队
    public queue_with_stack() {
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
    }

    public void offer(int value) {
     this.s1.push(value);
    }

    public void poll() {  //全部移到s2，然后pop s2的顶端数据
    if (this.s2.isEmpty()) {
        while(!this.s1.isEmpty()) {
            this.s2.push(this.s1.pop());
        }
    }
    if (!this.s2.isEmpty()) {
         int temp = this.s2.pop();
        System.out.println(temp);
    }
    }

    public void peek() {  //同poll一样，全部移到s2，peek顶端数据
    if(this.s2.isEmpty()) {
        while(!this.s1.isEmpty()) {
            this.s2.push(this.s1.pop());
        }
    }
    if(!this.s2.isEmpty()) {
        int temp = this.s2.peek();
        System.out.println(temp);
    }
    }

    public boolean isEmpty() {
     if(this.s1.isEmpty() && this.s2.isEmpty()) {
         return true;
     }
     return false;
    }

}
public class Queue_use_stack {
    public static void main(String[] args) {
        queue_with_stack queue = new queue_with_stack();
        queue.offer(22);
        queue.offer(3);
        queue.offer(12);
        queue.offer(66);
        queue.offer(42);
        queue.peek();
        queue.poll();
        queue.peek();
    }
}
