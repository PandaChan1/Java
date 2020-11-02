package Code.Work;
class Node{
    protected int val;
    protected Node next;
    protected Node pre;
    public Node(int key) {
        this.val = key;
    }
}
class MyLinkedList {
    public Node head ;
    public Node last;
    public int size ;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.head = null;
        this.last = null;
        this.size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(this.head == null || index >= this.size) {
            return -1;
        }
        Node cur = this.head;
        for(int i = 0;i < index;i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node = new Node(val);
        if(this.head == null) {
            this.head = node;
            this.last = node;
            this.size++;
            return;
        }
        this.head.pre = node;
        node.next = this.head;
        this.head = node;
        this.size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node node  = new Node(val);
        if(this.head == null) {
            addAtHead(val);
            return;
        }
        this.last.next = node;
        node.pre = this.last;
        this.last = node;
        this.size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > this.size) {
            return;
        }
        if(index == 0) {
            addAtHead(val);
            return;
        }

        if(index == this.size) {
            addAtTail(val);
            return;
        }
        Node node = new Node(val);
        Node cur = this.head;

        for(int i = 0;i < index;i++) {
            cur =cur.next;
        }
        node.next = cur;
        cur.pre.next = node;
        node.pre = cur.pre;
        cur.pre = node;
        this.size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index >= this.size) {
            return;
        }

        if(this.head.next == null) {
            this.head = null;
            this.size--;
            return;
        }
        if(index == 0) {
            this.head.next.pre = null;
            this.head = this.head.next;
            this.size--;
            return;
        }

        Node cur = this.head;
        for(int i  = 0;i < index;i++) {
            cur = cur.next;
        }
        if(cur.next == null) {
            this.last = this.last.pre;
            this.last.next = null;
        }else{
            cur.next.pre = cur.pre;
            cur.pre.next = cur.next;
        }
        this.size--;
    }
    public void display(){
        Node cur = head;
        while(cur != null) {
            System.out.print(cur.val + " " );
            cur = cur.next;
        }
        System.out.println();
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */