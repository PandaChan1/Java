package BSTree;

class BSTree{
    public Node root  = null;
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
                cur.data = key;
                return;
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

    //删除
    public void remove(int key) {

    }

    public void pre(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        pre(root.left);
        pre(root.right);
    }

    public void in(Node root) {
        if (root == null) return;
        in(root.left);
        System.out.print(root.data + " ");
        in(root.right);
    }

}

public class BinarySearchTree {
    public static void main(String[] args) {
        BSTree bsTree = new BSTree();
        bsTree.put(10);
        bsTree.put(30);
        bsTree.put(15);
        bsTree.put(2);
        bsTree.put(45);

        bsTree.pre(bsTree.root);
        System.out.println();
        bsTree.in(bsTree.root);
        System.out.println();

        try {
            System.out.println(bsTree.find(30));
        }catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("树中没有该数据");
        }

    }

}
