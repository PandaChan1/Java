package MyGenericList.MyGenericLinkedList;

/**
 *@ClassName: GenericDoubleHeadList
 *@Description 双向链表泛型实现
 *@Author PandaChan1
 *@Date 2020/11/20
 *@Time 19:27
 */


public class GenericDoubleHeadList<T>{
    static class DoubleNode<T>{ //内部类
        public T val;
        public DoubleNode<T> pre;
        public DoubleNode<T> next;
        public DoubleNode(T val) {
            this.val = val;
        }
    }

    public DoubleNode<T> head;
    public DoubleNode<T> tail;

    //插入
    public void addFirst(T val) {
        DoubleNode<T> node = new DoubleNode<>(val);
        if (isEmpty()) {
            this.head = node;
            this.tail = node;
            return;
        }
        node.next = this.head;
        this.head.pre = node;
        this.head = node;
    }
    public void addLast(T val) {
        DoubleNode<T> node = new DoubleNode<>(val);
        if (isEmpty()) addFirst(val);
        this.tail.next = node;
        node.pre = this.tail;
        this.tail = node;
    }
    public void addIndex(int index,T val) {
        if (isEmpty()) addFirst(val);
        if (index < 0 || index > size()) return;
        DoubleNode<T> node = new DoubleNode<>(val);
        if (index == 0) {
            addFirst(val);
            return;
        }
        if (index == size()) {
            addLast(val);
            return;
        }

        DoubleNode<T> cur = this.head;
        while(index > 0) {
            cur = cur.next;
            index--;
        }

        node.next = cur;
        node.pre = cur.pre;
        cur.pre.next = node;
        cur.pre = node;
    }
    //删除
    public void remove(T key) {
        if (isEmpty()) return;
        if (!contains(key)) return;
        DoubleNode<T> cur = this.head;
        while(cur != null) {
            if ( key.equals(cur.val)) {
                if (this.head.equals(cur)) {
                    this.head.next.pre = null;
                    this.head = this.head.next;
                }else {
                    cur.pre.next = cur.next;
                    if (this.tail.equals(cur)) {
                        this.tail = this.tail.pre;
                    }else {
                        cur.next.pre = cur.pre;
                    }
                }
                return;
            }
            cur = cur.next;
        }
    }
    public void removeAll(T key) {
        if (isEmpty()) return;
        if (!contains(key)) return;
        DoubleNode<T> cur = this.head;
        while(cur != null) {
            if (key.equals(cur.val)) {
                if (this.head.equals(cur)) {
                    this.head.next.pre = null;
                    this.head = this.head.next;
                }else {
                    cur.pre.next = cur.next;
                    if (this.tail.equals(cur)) {
                        this.tail = this.tail.pre;
                    }else {
                        cur.next.pre = cur.pre;
                    }
                }
            }
            cur = cur.next;
        }
    }
    //是否包含某个元素
    public boolean contains(T key) {
        if (isEmpty()) return false;
        DoubleNode<T> cur = this.head;
        while (cur != null ) {
            if (key.equals(cur.val)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    //返回指定下标的元素
    public DoubleNode<T> get(int index) {
        if (isEmpty()) return null;
        if (index < 0 || index > size()) {
            return null;
        }
        DoubleNode<T> cur = this.head;
        while (index > 0 ) {
            cur  = cur.next;
            index--;
        }
        return cur;
    }
    //判空
    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        }
        return  false;
    }
    //大小
    public int size() {
        if (isEmpty()) return 0;
        DoubleNode<T> cur = this.head;
        int size = 0;
        while(cur != null) {
            size++;
            cur = cur.next;
        }
        return size;
    }
    //清空链表
    public void clear() {
        this.head = null;
        this.tail = null;
    }
    //打印链表
    public void display() {
        if (isEmpty()) return;
        DoubleNode<T> cur = this.head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
