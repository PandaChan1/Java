package Code;

class LinkedList {
    int data;
    LinkedList next;
    LinkedList prev;

    public LinkedList() {
    }

    public LinkedList(int val) {
        this.data = val;
    }
}

public class PupLinkedList {
    LinkedList last;
    LinkedList dummyhead;

    public LinkedList getDummyhead() {
        return dummyhead;
    }

    public PupLinkedList() {
        this.dummyhead = new LinkedList(-1);
    }

    //头插
    public void addFirst(int data) {
        LinkedList node = new LinkedList(data);
        if (this.dummyhead.next == null) {
            this.dummyhead.next = node;
            node.prev = this.dummyhead;
            this.last = node;
        } else {
            node.next = this.dummyhead.next;
            this.dummyhead.next.prev = node;
            node.prev = this.dummyhead;
            this.dummyhead.next = node;
        }

    }

    //尾插
    public void addLast(int data) {
        LinkedList node = new LinkedList(data);
        if (this.dummyhead.next == null) {
            addFirst(data);
        } else {
            this.last.next = node;
            node.prev = this.last;
            this.last = node;
        }
    }

    private LinkedList searchIndex(int index) {
        if (index < 0 || index > size()) {
            System.out.println("index错误");
            return null;
        }
        LinkedList cur = this.dummyhead.next;
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
        }
        if (index == size()) {
            addLast(data);
        }
        LinkedList node = new LinkedList(data);
        LinkedList indexNode = searchIndex(index);
        if (indexNode == null) {
            return;
        }
        node.next = indexNode;
        indexNode.prev.next = node;
        node.prev = indexNode.prev;
        indexNode.prev = node;

    }

    //链表的大小
    public int size() {
        LinkedList cur = this.dummyhead.next;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    //链表中是否包含某个元素
    public boolean contains(int data) {
        LinkedList cur = this.dummyhead.next;
        while (cur != null) {
            if (cur.data == data) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //清空链表
    public void clear() {
        this.dummyhead.next = null;
        this.last = null;
    }

    //打印链表
    public void display() {
        LinkedList cur = this.dummyhead.next;
        while (cur != null) {
            System.out.print(cur.data + "  ");
            cur = cur.next;
        }
        System.out.println();
    }

    //删除第一次出现的节点
    public void remove(int key) {
        LinkedList cur = this.dummyhead.next;
        while (cur != null) {
            if (cur.data == key) {
                if (this.dummyhead.next.data == key) { //删除的是头节点
                    this.dummyhead.next = this.dummyhead.next.next;
                    this.dummyhead.next.prev = null;
                } else if (cur.next == null) {  //删除的是尾节点
                    cur.prev.next = cur.next;
                    this.last = this.last.prev;
                } else { //其他节点
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                }
                return;
            } else {
                cur = cur.next;
            }
        }
    }

    //删除所有出现的节点
    public void removeAll(int key) {
        LinkedList cur = this.dummyhead.next;
        while(cur != null) {
            if (cur.data == key) {
                if(this.dummyhead.next.data == key) {  //删除头节点
                    this.dummyhead.next = this.dummyhead.next.next;
                    this.dummyhead.next.prev = null;
                }else {
                    if(cur.next == null) {  //删除尾节点
                        cur.prev.next = null;
                        this.last = this.last.prev;
                    }else {
                        cur.prev.next = cur.next;
                        cur.next.prev = cur.prev;
                    }
                }
            }
            cur = cur.next;
        }
    }
}
