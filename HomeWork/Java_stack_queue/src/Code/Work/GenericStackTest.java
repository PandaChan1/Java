package Code.Work;

import java.util.Arrays;
import java.util.Objects;

/**
 *@ClassName: GenericStackTest
 *@Description 使用泛型和数组实现栈
 *@Author PandaChan1
 *@Date 2020/11/3
 *@Time 10:20
 */

class genericStack<T>{
    protected T[] elem;
    protected int usedsize;


    public genericStack(){
        this.elem =  (T[])new Object[5];
    }

    public void pop() {  //弹出,删除元素
        if (isEmpty()) {
            System.out.println("栈空，无法pop");
            return;
        }
        this.usedsize--;
        System.out.println(this.elem[this.usedsize]);
    }


    public void push(T val) {
        if (isFull()) {
            System.out.println("栈满，无法push");
            return;
        }
        this.elem[this.usedsize] = val;
        this.usedsize++;
    }


    public void peek() {  //返回栈顶元素
        System.out.println(this.elem[this.usedsize - 1]);
    }


    public boolean isEmpty() {
        if (this.usedsize == 0) {
            return true;
        }
        return false;
    }



    public boolean isFull() {
        if(this.usedsize == this.elem.length) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "genericStack{" +
                "elem=" + Arrays.toString(elem) +
                '}';
    }
}
public class GenericStackTest<T> {
    public static void main(String[] args) {
        genericStack<String> genericStack = new genericStack<>();
        genericStack.push("h");
        genericStack.push("e");
        genericStack.push("l");
        genericStack.push("l");
        genericStack.push("o");

        System.out.println(genericStack.toString());
        genericStack.pop();
        genericStack.peek();
        System.out.println(genericStack.isFull());
        System.out.println(genericStack.isEmpty());
    }
}
