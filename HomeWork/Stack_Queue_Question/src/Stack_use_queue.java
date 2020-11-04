import java.util.LinkedList;
import java.util.Queue;

/**
 *@ClassName: Stack_use_queue
 *@Description 队列实现栈
 *@Author PandaChan1
 *@Date 2020/11/4
 *@Time 18:15
 */

class stack_with_queue{
    public Queue<Integer> que1;
    public Queue<Integer> que2;
    public int usedsize;
    public stack_with_queue(){
        this.que1 = new LinkedList<>();
        this.que2 = new LinkedList<>();
    }

    public void push(int val) {  //队不为空就放，两个队都为空随机选一个放
        if (!this.que1.isEmpty()) {
            this.que1.offer(val);
        }else if(!this.que2.isEmpty()){
            this.que2.offer(val);
        }else {
            this.que1.offer(val);
        }
        this.usedsize++;
    }

    public void pop() {  //队不为空，把队里前size-1个移到空队中，然后poll最后一个
        if (isEmpty()) {
            System.out.println("队空，无法pop");
            return;
        }
        int i = this.usedsize - 1;
        if (!this.que1.isEmpty()) {
           while(i > 0) {
               this.que2.offer(this.que1.poll());
               i--;
           }
            this.usedsize--;
            System.out.println(this.que1.poll());

        }else if (!this.que2.isEmpty()) {
          while(i > 0) {
              this.que1.offer(this.que2.poll());
              i--;
          }
            this.usedsize--;
            System.out.println(this.que2.poll());
        }
    }

    public void peek() {  //队不为空，就把所有元素移到空的里面，temp标记的就是栈的顶端节点
    if (isEmpty()) {
        System.out.println("队空，无法peek");
        return;
    }
    int index = this.usedsize;
    int temp = -1;
    if(!this.que1.isEmpty()) {
        while(index > 0) {
            temp = this.que1.poll();
            this.que2.offer(temp);
            index--;
        }
    }else if(!this.que2.isEmpty()) {
        while(index > 0) {
            temp = this.que2.poll();
            this.que1.offer(temp);
            index--;
        }
    }
        System.out.println(temp);
    }

    public boolean isEmpty() {
        if (this.que2.isEmpty() && this.que1.isEmpty()) {
            return true;
        }
        return false;
    }
}
public class Stack_use_queue {
    public static void main(String[] args) {
        stack_with_queue queue = new stack_with_queue();
        queue.push(2);
        queue.push(45);
        queue.push(6);
        queue.push(88);
        queue.peek();
        queue.pop();
        queue.peek();

    }
}
