package Code;

/**
 * @ClassName: Node
 * @Description 双向链表
 * @Author PandaChan1
 * @Date 2020/10/23
 * @Time 15:56
 */


class Node {
    public int data;
    public Node next;
    public Node prev;

    public Node() {

    }

    public Node(int data) {
        this.data = data;
    }
}

public class DoubleLinkedList {
    public Node head;
    public Node last;

    //头插
    public void addFirst(int data) {
        Node node = new Node(data);
        if (this.head == null || this.last == null) {  //第一次插入
            this.head = node;
            this.last = node;
        } else {
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
    }

    //尾插
    public void addLast(int data) {
        Node node = new Node(data);
        if (this.head == null || this.last == null) {
            this.head = node;
            this.last = node;
        } else {
            this.last.next = node;
            node.prev = this.last;
            this.last = node;
        }
    }

    //双向链表大小
    public int size() {
        if (this.head == null || this.last == null) {
            return -1;
        }
        Node cur = this.head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    //链表是否包含某个元素
    public boolean contains(int key) {
        if (this.head == null || this.last == null) {
            return false;
        }
        Node cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //打印链表
    public void display() {
        if (this.head == null || this.last == null) {
        }
        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    private Node searchIndex(int index) {
        if (index < 0 || index > size()) {
            System.out.println("index不合法");
            return null;
        }
        Node cur = this.head;
        while (index != 0) {
            cur = cur.next;
            index--;
        }
        return cur;
    }

    //任意位置插入
    public void addIndex(int index, int data) {
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size()) {
            addLast(data);
            return;
        }
        Node node = new Node(data);
        Node cur = searchIndex(index);
        if (cur == null) {
            return;
        }
        node.next = cur;
        cur.prev.next = node;
        node.prev = cur.prev;
        cur.prev = node;
    }

    //删除第一次出现关键字为key的节点
    public void remove (int key) {
        Node cur = this.head;
        while(cur != null) {
            if(cur.data == key) {
                if(this.head.data == key) {  //删除的是头节点
                    this.head = this.head.next;
                    this.head.prev = null;
                }else {  //删除的不是头节点
                    cur.prev.next = cur.next;
                    if(cur.next != null) {  //cur.next != null 中间节点
//                        cur.prev.next = cur.next;
                        cur.next.prev = cur.prev;
                    }else {  //尾节点
//                        cur.prev.next = cur.next;
                        this.last = this.last.prev;
                    }
                }
                return;
            }else {
                cur =cur.next;
            }
        }
        return;
    }

    //删除所有值为key的节点
    public void removeAllKey(int key){
        Node cur = this.head;
        while(cur != null) {
            if(cur.data == key) {
                if(this.head.data == key) {  //删除的是头节点
                    if (this.head.next == null) {
                        this.head = null;
                        return;
                    }
                    this.head = this.head.next;
                    this.head.prev = null;
                }else {  //删除的不是头节点
                    cur.prev.next = cur.next;
                    if(cur.next != null) {  //cur.next != null 中间节点
//                        cur.prev.next = cur.next;
                        cur.next.prev = cur.prev;
                    }else {  //尾节点
//                        cur.prev.next = cur.next;
                        this.last = this.last.prev;
                    }
                }
            }
                cur =cur.next;

        }
        return;
    }

    //清空链表
    public void clear(){
        this.head = null;
        this.last = null;
    }

}
