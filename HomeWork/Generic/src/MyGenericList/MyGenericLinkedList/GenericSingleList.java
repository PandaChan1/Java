package MyGenericList.MyGenericLinkedList;

/**
 *@ClassName: GenericSingleList
 *@Description 单链表泛型实现
 *@Author PandaChan1
 *@Date 2020/11/20
 *@Time 19:27
 */



public class GenericSingleList<T> {
    static class singleNode<T>{
        public T val;
        public singleNode<T> next;
        public singleNode(T val) {
            this.val = val;
        }
    }

    public singleNode<T> head;
    //插入
 public void addFirst(T val) {
     singleNode<T> node = new singleNode<T>(val);
     if (isEmpty()) {
         this.head = node;
         return;
     }
     node.next = this.head;
     this.head = node;
 }

 public void addLast(T val) {
     singleNode<T> node = new singleNode<T>(val);
     if (isEmpty()) {
         this.head = node;
     }else {
         singleNode<T> cur = this.head;
         while(cur.next != null) {
             cur = cur.next;
         }
         cur.next = node;
     }

 }

 public void addIndex(int index,T val) {
     if (index < 0 || index > size()) {
         return;
     }
     if (index == 0) {
         addFirst(val);
         return;
     }
     if (index == size()) {
         addLast(val);
         return;
     }

     singleNode<T> node = new singleNode<T>(val);
     singleNode<T> pre = searchPre(index);

     node.next = pre.next;
     pre.next  = node;
 }

    private singleNode<T> searchPre(int index) {
     singleNode<T> cur = this.head;
        while(index - 1 > 0) {
            cur = cur.next;
            index--;
        }
        return cur;
    }

    //删除第一个遇到的关键字
    public void remove(T key) {
    if (isEmpty()) {
        return;
    }
    if (key.equals(this.head.val)) {
        this.head = this.head.next;
        return;
    }
    singleNode<T> cur = this.head;
    while(cur.next != null) {
        if ( key.equals(cur.next.val)) {
            cur.next = cur.next.next;
            return;
        }
        cur = cur.next;
    }
    }
    public void removeAll(T key) {
        if (isEmpty()) {
            return;
        }
        if (key.equals(this.head.val)) {
            this.head = this.head.next;
            return;
        }
        singleNode<T> cur = this.head;
        while(cur.next != null) {
            if (key.equals(cur.next.val)) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
    }

    //包含某个元素
    public boolean contains(T key) {
    if (isEmpty()) {
        return false;
    }
    singleNode<T> cur = this.head;
    while(cur != null) {
        if (key.equals(cur.val)) {
            return true;
        }
        cur = cur.next;
    }
    return false;
    }
    //清空链表
    public void clear() {
        this.head = null;
    }
    //判空
    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        }
        return false;
    }
    //返回大小
    public int size() {
        if (isEmpty()) {
            return 0;
        }
        singleNode<T> cur = this.head;
        int size = 0;
        while(cur != null) {
            size++;
            cur = cur.next;
        }
        return size;
    }
    //打印
    public void display() {
     if (isEmpty()) return;
     singleNode<T> cur = this.head;
     while (cur != null) {
         System.out.print(cur.val + " ");
         cur = cur.next;
     }
        System.out.println();
    }

}
