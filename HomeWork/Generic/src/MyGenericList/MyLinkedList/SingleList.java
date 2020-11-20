package MyGenericList.MyLinkedList;
/**
 *@ClassName: singleNode
 *@Description 单链表复习
 *@Author PandaChan1
 *@Date 2020/11/20
 *@Time 19:27
 */


class singleNode{
    public int val;
    public singleNode next;
    public singleNode(int val) {
        this.val = val;
    }
}
public class SingleList {
    public singleNode head;
    //插入
 public void addFirst(int val) {
     singleNode node = new singleNode(val);
     if (isEmpty()) {
         this.head = node;
         return;
     }
     node.next = this.head;
     this.head = node;
 }

 public void addLast(int val) {
     singleNode node = new singleNode(val);
     if (isEmpty()) {
         this.head = node;
     }else {
         singleNode cur = this.head;
         while(cur.next != null) {
             cur = cur.next;
         }
         cur.next = node;
     }

 }

 public void addIndex(int index,int val) {
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

     singleNode node = new singleNode(val);
     singleNode pre = searchPre(index);

     node.next = pre.next;
     pre.next  = node;
 }

    private singleNode searchPre(int index) {
     singleNode cur = this.head;
        while(index - 1 > 0) {
            cur = cur.next;
            index--;
        }
        return cur;
    }

    //删除第一个遇到的关键字
    public void remove(int key) {
    if (isEmpty()) {
        return;
    }
    if (this.head.val == key) {
        this.head = this.head.next;
        return;
    }
    singleNode cur = this.head;
    while(cur.next != null) {
        if (cur.next.val == key) {
            cur.next = cur.next.next;
            return;
        }
        cur = cur.next;
    }
    }
    public void removeAll(int key) {
        if (isEmpty()) {
            return;
        }
        if (this.head.val == key) {
            this.head = this.head.next;
            return;
        }
        singleNode cur = this.head;
        while(cur.next != null) {
            if (cur.next.val == key) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
    }

    //包含某个元素
    public boolean contains(int key) {
    if (isEmpty()) {
        return false;
    }
    singleNode cur = this.head;
    while(cur != null) {
        if (cur.val == key) {
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
        singleNode cur = this.head;
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
     singleNode cur = this.head;
     while (cur != null) {
         System.out.print(cur.val + " ");
         cur = cur.next;
     }
        System.out.println();
    }

}
