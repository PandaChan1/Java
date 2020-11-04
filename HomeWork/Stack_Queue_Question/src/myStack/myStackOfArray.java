package myStack;

import java.util.Arrays;
/**
 *@ClassName: stackOfArray
 *@Description 顺序栈，使用泛型
 *@Author PandaChan1
 *@Date 2020/11/4
 *@Time 13:55
 */


class stackOfArray<T>{
    public T[] elem;
    public int usedsize;
    public stackOfArray() {
        this.elem = (T[]) new Object[5];
    }

    public void push(T value) {  //往栈中压入元素
     if(isFull()) {
         this.elem = Arrays.copyOf(this.elem,this.elem.length * 2);
//         System.out.println("栈满，无法push");
//         return;
     }
     this.elem[this.usedsize] = value;
     this.usedsize++;
    }

    public void pop() {  //获取栈顶元素，并删除
        if (isEmpty()) {
            System.out.println("栈空，不能pop");
            return;
        }
        System.out.println(this.elem[this.usedsize - 1]);
        this.usedsize--;
    }

    public void peek() {  //获取栈顶元素，不删除
        if (isEmpty()) {
            System.out.println("栈空，不能peek");
            return;
        }
        System.out.println(this.elem[this.usedsize - 1]);
    }

    public boolean isEmpty() {  //判空
        if(this.usedsize == 0) {
            return true;
        }
        return false;
    }

    public boolean isFull() {  //判满
        if (this.elem.length == this.usedsize) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "stackOfArray{" +
                "elem=" + Arrays.toString(elem) +
                '}';
    }
}
public class myStackOfArray {
    public static void main(String[] args) {
        stackOfArray<Integer> stack = new stackOfArray<>();
        stack.push(2);
        stack.push(65);
        stack.push(99);
        stack.push(9);
        stack.push(25);
        stack.push(88);
        stack.push(10);
        System.out.println(stack.toString());
//        stack.peek();
//        System.out.println(stack.toString());
//        stack.pop();
//        stack.push(55);
//        System.out.println(stack.toString());
//        System.out.println(stack.isEmpty());
//        System.out.println(stack.isFull());
    }
}
