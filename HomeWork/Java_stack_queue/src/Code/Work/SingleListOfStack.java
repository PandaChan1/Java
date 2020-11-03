package Code.Work;

/**
 *@ClassName: SingleListOfStack
 *@Description 单向链表实现栈
 *@Author PandaChan1
 *@Date 2020/11/3
 *@Time 10:21
 */

/**
 * 单向链表实现栈使用头插、头删方法  时间复杂度都为O(1)
 * 尾删、尾插法每次都需要找到尾部，时间复杂度为O(n)
 */
class stackOfNode{
    protected int val;
    protected stackOfNode next;
    public stackOfNode(int value) {
        this.val = value;
    }
}
class listOfStack{
    protected stackOfNode head;

    public void push(int val) {  //头插
        stackOfNode node = new stackOfNode(val);
        if(this.head == null) {
            this.head = node;
            return;
        }
        node.next = this.head;
        this.head = node;
    }

    public void pop() { //头删
        if (this.head == null) {
            System.out.println("栈中没有元素，不能pop");
            return;
        }

        System.out.println(this.head.val);
        this.head = this.head.next;
    }

    public void peek() {  //弹出栈顶元素，不删除
        if(this.head == null) {
            System.out.println("栈中没有元素，不能peek");
            return;
        }
        System.out.println(this.head.val);
    }

    public void disply() {
        stackOfNode cur = this.head;
        while(cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
public class SingleListOfStack {
    public static void main(String[] args) {
        listOfStack listOfStack = new listOfStack();
        listOfStack.push(2);
        listOfStack.push(3);
        listOfStack.push(4);
        listOfStack.disply();
        listOfStack.pop();
        listOfStack.disply();
        listOfStack.peek();
        listOfStack.disply();
    }
}
