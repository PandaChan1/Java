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
        int count = 0;
        while (count < index - 1) {
            cur = cur.next;
            count++;
        }
        return cur;
    }

    //任意位置插
    public void addIndex(int index, int data) {
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
        prev.next = node;
    }

    //是否包含某个元素
    public boolean contains(int data) {
        myNode cur = this.head;
        while (cur != null) {
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
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    //找到要删除节点的前一个节点
    private myNode searchRemovePrevNode(int key) {
        myNode cur = this.head;
        while (cur.next != null) {
            if (cur.next.data == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    //删除第一次出现的关键字
    public void remove(int key) {
        if (this.head.data == key) {  //删除头节点
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
//        while(contains(key)) {
//            remove(key);
//        }

        myNode cur = this.head.next;
        myNode prev = this.head;

        while (cur != null) {
            if (cur.data == key) {
                prev.next = cur.next;
//                cur = cur.next;
            } else {
                prev = cur;
//                cur = cur.next;
            }
           cur = cur.next;
        }

        if(this.head.data == key)
            this.head = this.head.next;
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

    //找到中间节点，有两个中间节点返回第二个
    public myNode middleNode() {
        myNode fast = this.head;
        myNode last = this.head;

        while (fast != null && fast.next != null) {
         fast = fast.next.next;
         last = last.next;
        }
        return last;
    }
    //反转链表
    public myNode reserve() {
        myNode prev = null;
        myNode cur = this.head;
        while (cur != null) {
            myNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public void display(myNode head) {
        while(head != null) {
            System.out.print(head.data + "  ");
            head = head.next;
        }
        System.out.println();
    }

    //找到倒数第k个节点
    public myNode findKthNode (int k) {
//        if (k <= 0 || k > size()) {
//            return null;
//        }
        if (k <= 0) {
            return null;
        }
        myNode fast = this.head;
        myNode last = this.head;

//        //先走k-1次
//            for (int i = 0; i < k - 1; i++) {
//                fast = fast.next;
//            }
        while(k - 1 > 0 ) {
            if (fast.next != null) {
             fast = fast.next;
             k--;
            }else {
                System.out.println("没有这个节点");
                return null;
            }
        }

            while (fast.next != null) {
                fast = fast.next;
                last = last.next;
            }
        return last;
    }
}
