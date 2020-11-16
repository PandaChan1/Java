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
    public boolean remove(int key) {
        Node current = root;
        Node pre = root;
        boolean isLeft = true;  //标记是否为左节点

        //查询是否存在该节点
        while(current.data != key) {
            pre = current;
            if (current.data > key) {
                isLeft = true;
                current = current.left;
            }else {
                isLeft = false;
                current = current.right;
            }
            if (current == null) {
                return false;
            }
        }
        //此时，current.data == key
        //第一种情况  current左右节点都为空

        if (current.left == null && current.right == null) {
            if (current == root) {  //判断是不是根
                root = null;
            }else {
                if (isLeft) {  //判断是不是左节点
                    pre.left = null;
                }else {
                    pre.right = null;
                }
            }
            return true;
        }else if (current.left  == null || current.right == null){   //左右节点有一个为空
            if (current.left == null) {  //左节点为空
                if (current == root) {  //判断根节点
                    root = root.right;
                }else {
                    if (isLeft) {  //current是左节点
                        pre.left = current.right;
                    }else {
                        pre.right = current.right;
                    }
                }
                return true;
            }else {  //右节点为空
                if (current == root) {
                    root = root.left;
                }else {
                    if (isLeft) {
                        pre.left = current.left;
                    }else {
                        pre.right = current.left;
                    }
                }
                return true;
            }
        }else {  //删除的节点左右都不为空
        Node newNode = getNewNode(current);
            if (newNode == root) {
                root = newNode;
            }else {
                if (isLeft) {
                    pre.left = newNode;
                }else {
                    pre.right = newNode;
                }
            }
            //删除后新的替补节点的左树就是原来节点的左树
            newNode.left = current.left;
            return true;
        }

    }

    private Node getNewNode(Node del) {
        Node parent = del;
        Node find = del;  //标记删除的节点中序遍历结果的后一个节点的位置
        Node cur = del.right;  //删除的节点有左右子树，删除该节点后替补节为中序遍历结果中该节点的后一个节点
        while(cur != null) {
            parent = find;
            find = cur;
            cur = cur.left;  //替补节点在删除节点的右子树的左孩子中
        }
        //此时cur为空
        if (del.right != find) {  //如果要删除的节点右子树有左孩子
            parent.left = find.right;
            find.right = del.right;
        }
        return find;  //找到节点的位置
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
        bsTree.put(17);
        bsTree.put(16);
        bsTree.put(25);

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
        bsTree.remove(15);
        bsTree.pre(bsTree.root);
        System.out.println();
        bsTree.in(bsTree.root);

    }

}
