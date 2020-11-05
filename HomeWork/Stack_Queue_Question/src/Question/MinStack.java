package Question;

import java.util.Stack;

/**
 *@ClassName: MinStack
 *@Description 设计一个最小栈
 *@Author PandaChan1
 *@Date 2020/11/5
 *@Time 16:10
 */

class myMinStack{
    private Stack<Integer> stack;  //
    private Stack<Integer> minStack;  //存最小的数据
    public myMinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int val) {
        this.stack.push(val);  //stack每次都入
        if (this.minStack.isEmpty()) {  //最小栈为空，先入
            this.minStack.push(val);
            return;
        }

        if(!this.minStack.isEmpty()) {
            if (val <= this.minStack.peek()) {  //val <= 最小栈栈顶元素，则push，大于则不做任何操作
                this.minStack.push(val);
            }
        }
    }

    public void pop() {
         int temp = this.stack.pop();  //stack存了全部元素，pop时直接pop

        if (this.minStack.peek() == temp) {
            //minStack中存储最小元素，pop时判断stack顶的元素是否与minStack顶的元素相同
            //相同则minStack也pop()
            this.minStack.pop();
        }
        System.out.println(temp);  //输出pop()的元素
    }

    public void peek() {
        System.out.println(this.stack.peek());
    }

    public void getMin() {
        System.out.println(this.minStack.peek());
    }
}
public class MinStack {
    public static void main(String[] args) {
        myMinStack stack = new myMinStack();
        stack.push(6);
        stack.push(12);
        stack.push(3);
        stack.push(-2);
        stack.push(99);
        stack.peek();
        stack.pop();
        stack.peek();
        stack.getMin();
    }
}
