package BSTree;

class BSTree{
    Node root  = null;
    static class Node{
        public int data;
        public Node left;
        public Node right;
        public Node(int val) {
            this.data = val;
        }
    }

    //插入
    public void put(int key) {
        Node node = new Node(key);
        if (root == null) {
            root = node;
            return;

        }

        Node parent = null;
        Node cur = root;
        while(cur != null) {
            if (cur.data < key) {
                parent = cur;
                cur = cur.right;
            }else if(cur.data > key) {
                parent = cur;
                cur = cur.left;
            }else {
                //数字相同没有处理
                break;
            }
        }

        //cur == null parent = cur的父亲
        if (parent.data < key) {
            parent.right = node;
        }else if (parent.data > key) {
            parent.left = node;
        }
    }

    //查找
    public Node find(int key) {
        if (root == null) return  null;
        Node cur = root;
        while(cur != null) {
            if (cur.data == key) return cur;
            else if(cur.data < key) {
                cur = cur.right;
            }else {
                cur = cur.left;
            }
        }
        return cur;
    }

}

public class BinarySearchTree {

}
