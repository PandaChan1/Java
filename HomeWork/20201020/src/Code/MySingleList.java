package Code;

/**
 *@ClassName: MySingleList
 *@Description 实现单链表
 *@Author PandaChan1
 *@Date 2020/10/20
 *@Time 18:31
 */

class Node{
    public int data;
    public Node next;  //节点就是一个对象，next中存储下一个节点的地址，是一个引用类型
    public Node() {

    }
    public Node(int data) {
        this.data = data;
        //没有初始化Next，因为不知道Next当前指向哪个节点
    }
}
public class MySingleList {
    public Node head;  //定位头节点

    //头插入
    public void addFirst(int data) {
        Node node = new Node(data);
        if (this.head == null) {  //第一次插入时
        }else {
            node.next = head;
        }
        this.head = node;

    }


    //尾插
    public void addLast(int data) {
        Node node = new Node(data);
        if (this.head == null) {
//            addFirst(data);
            this.head = node;
            return;
        }else {
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }


    //找到index - 1位置的节点
    private Node searchPrev(int index) {
        int count = 0;
        Node cur = this.head;
        while(count < index - 1) {
            count++;
            cur = cur.next;
        }
        return cur;
    }
    //任意位置插入
    public void addIndex(int index,int data) {
        if (index < 0 || index > size()) {
            System.out.println("插入位置不合法");
            return;
        }
        Node node = new Node(data);
        if (index == 0) {
            addFirst(data);
        }else {
            Node prev = searchPrev(index);
            node.next = prev.next;
            prev.next = node;
        }
    }


    //打印单链表
    public void display() {
        Node cur = this.head;
        while(cur != null) {
            System.out.print(cur.data + "  ");
            cur = cur.next;
        }
        System.out.println();
    }

    //判断单链表是否含有某个元素
    public boolean contains(int data) {
        Node cur = this.head;
        while(cur != null) {
            if (cur.data == data) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

//    //清空单链表
//    public void clear() {
//    this.head = null;
//    }

    //返回单链表的长度
    public int size() {
        Node cur = this.head;
        int count =0;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        if (count != 0) {
            return count;
        }else {
            return -1;
        }
    }

    //找关键字key的前驱
    private Node searchPrevNode(int key) {
        Node cur = this.head;
        while(cur.next != null) {
            if (cur.next.data == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    //移除某一个元素
    public void remove(int key) {
        if (this.head.data == key) {  //移除的是头节点
            this.head = this.head.next;
            return;
        }
        Node prev = searchPrevNode(key);
        if (prev == null) {
            System.out.println("该元素不存在");
            return;
        }
        prev.next = prev.next.next;
    }

    //移除单链表中所有的该元素
    public void removeAllKey(int key) {
        while (contains(key)) {
            remove(key);
        }
    }

}
