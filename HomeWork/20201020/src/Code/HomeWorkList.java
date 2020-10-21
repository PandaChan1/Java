package Code;

class myNode{
    public int data;
    public myNode next;

    public myNode(int data) {
        this.data = data;
    }

}
public class HomeWorkList {
    public myNode head;  //标记头节点

    //头插
    public void addFirst(int data) {
        myNode node = new myNode(data);
        if (this.head == null) {
            this.head = node;
            return;
        }
        node.next = this.head;
        this.head = node;
    }
    //尾插
    public void addLsat(int data) {
        myNode node = new myNode(data);
        myNode cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }
    //index -1 位置的节点
    private myNode indexPrev(int index) {
       myNode cur = this.head;
       int count =0;
       while(count < index -1) {
           cur = cur.next;
           count++;
       }
       return cur;
    }
    //任意位置插
    public void addIndex(int index,int data) {
        if (index < 0 || index > size()) {
            System.out.println("位置不合法");
            return;
        }
        if (index == 0) {  //插入位置为0，即头插
            addFirst(data);
            return;
        }
        myNode prev = indexPrev(index);
        myNode node = new myNode(data);
        node.next = prev.next;
        prev.next =node;
    }
    //是否包含某个元素
    public boolean contains(int data) {
        myNode cur = this.head;
        while(cur != null) {
            if (cur.data == data) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    //单链表的大小
    public int size() {
        myNode cur = this.head;
        int count =0;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    //找到要删除节点的前一个节点
    private myNode searchRemovePrevNode(int key) {
        myNode cur = this.head;
        while(cur.next != null) {
            if (cur.next.data == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
    //删除第一次出现的关键字
    public void remove(int key) {
        if (this.head.data ==  key) {  //删除头节点
            this.head = this.head.next;
            return;
        }

        myNode prevNode = searchRemovePrevNode(key);
        if (prevNode == null) {
            System.out.println("没有找到元素");
            return;
        }
        prevNode.next = prevNode.next.next;
    }
    //删除所有关键字
    public void removeAllKey(int key) {
        while(contains(key)) {
            remove(key);
        }
    }
    //打印所有节点
    public void display() {
        myNode cur = this.head;
        while(cur != null) {
            System.out.print(cur.data + "  ");
            cur = cur.next;
        }
        System.out.println();
    }
}
