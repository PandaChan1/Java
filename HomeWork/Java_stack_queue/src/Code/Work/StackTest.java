package Code.Work;

import java.util.Arrays;

/**
 *@ClassName: myStack
 *@Description 数组实现栈  顺序栈
 *@Author PandaChan1
 *@Date 2020/11/3
 *@Time 10:21
 */


class myStack{
    public int[] elem;
    public int usedsize;
    public myStack(){
        this.elem = new int[5];
    }

    public void push(int item) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        this.elem[this.usedsize] = item;
        this.usedsize++;
    }

    public void pop() {
        if(isEmpty()) {
            System.out.println("栈空");
            return;
        }
        this.usedsize--;
        System.out.println(this.elem[this.usedsize]);
    }

    public void peek(){
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }
        System.out.println(this.elem[this.usedsize - 1]);
    }

    public boolean isEmpty(){
        if(this.usedsize == 0) {
            return true;
        }
        return false;
    }
    public boolean isFull(){
        if (this.usedsize == this.elem.length) {
            return true;
        }
        return false;
    }

}



public class StackTest {
    public static void main(String[] args) {
        myStack stack = new myStack();
        stack.push(1);
        stack.push(6);
        stack.push(88);
        stack.push(77);
        stack.push(66);
        System.out.println(stack.isFull());
        stack.pop();
//        System.out.println(stack.isEmpty());
        stack.peek();
    }
}
