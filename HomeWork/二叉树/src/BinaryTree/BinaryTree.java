package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *@ClassName: BinaryTree
 *@Description 二叉树
 *@Author PandaChan1
 *@Date 2020/11/5
 *@Time 10:41
 */

class Node{
    public char val;
    public Node left;
    public Node right;
    public Node(char value) {
        this.val = value;
    }
}
public class BinaryTree {
    public  Node createTree() {
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        Node H = new Node('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.right = H;
        C.left = F;
        C.right = G;
        return A;
    }
    //前序遍历
    void preOrderTraversal(Node root) {
     if (root == null) return;
        System.out.print(root.val + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    //中序遍历
    void inOrderTraversal(Node root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        System.out.print(root.val + " ");
        inOrderTraversal(root.right);
    }

    //后序遍历
    void postOrderTraversal(Node root) {
        if (root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val + " ");
    }

    //前序非递归
    void preorderTraversalNor(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<Node>();
        Node cur = root;

        while(cur != null || !stack.isEmpty()) {  //cur为空时，栈中还有元素就可以pop
            while(cur != null) {
                stack.push(cur);
                System.out.print(cur.val +  " " );
                cur = cur.left;
            }

            Node top = stack.pop();
            cur = top.right;  //cur可能为空
        }
    }

    //中序非递归
    void inorderTraversalNor(Node root) {
    if(root == null) {
        return ;
    }
    Stack<Node> stack = new Stack<Node>();
    Node cur = root;
    while(cur != null || !stack.isEmpty()) {
        while(cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        Node top =  stack.pop();
        System.out.print(top.val + " ");
        cur = top.right;
    }

    }
    //后序非递归
    void postorderTraversalNor(Node root) {
        if (root == null) return;
        Stack<Node> stack = new Stack<Node>();
        Node cur = root;
        Node prev = null;
        while(cur != null || !stack.isEmpty()) {

            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.peek();

            if (cur.right == null || cur.right == prev) {
                stack.pop();
                System.out.print(cur.val + " ");
                prev = cur;
                cur = null;
            } else {
                cur = cur.right;
            }
        }

    }

    //子问题思路---化解为子问题递归
    int getSize(Node root) {  //递归，节点为空返回0，不为空 +1
        //求root.size = root.left.size + root.right.size;
        if (root == null) {
            return 0;
        }
        return 1 + getSize(root.left) + getSize(root.right);
    }


    //遍历求size
    static int size = 0;
    void size(Node root) {
        if (root == null) return;
        size++;  //不为空
        size(root.left);
        size(root.right);
    }

    //求二叉树叶子数---递归思路
    //root的叶子数，为左子树叶子数加右子树叶子数
    //当root为空时叶子数为0
    //当root的左右都为空时，该root节点为叶子节点
    int getLeafSize(Node root) {
        if (root == null) {
            return 0;
        }
        if(root.right == null && root.left == null) {
            return 1;
        }
        return getLeafSize(root.right) + getLeafSize(root.left);
    }

    //求叶子数---遍历思路
    //是叶子则leaves++
    static int leaves = 0;
    void getLeaf(Node root) {
        if (root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            leaves++;
        }
        getLeaf(root.left);
        getLeaf(root.right);
    }

    //子问题思路----求第k层节点数
    int getKLeef(Node root,int k) {
        if (root == null) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return getKLeef(root.left,k - 1) + getKLeef(root.right, k - 1);
    }

    //获取二叉树的高度
    int height(Node root) {
        if (root == null) return  0;
        return Math.max(height(root.left),height(root.right)) + 1;
    }

    //寻找val所在的节点
    Node find(Node root,char val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        Node resleft = find(root.left,val);
        Node resright = find(root.right,val);
        if (resleft != null) {
            return resleft;
        }else {
            return resright;
        }
    }

    //层序遍历
    void levelOrderTraversal(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);


        while(!queue.isEmpty()) {
            Node cur;
            cur = queue.poll();
            System.out.print(cur.val + " ");
            if (cur.left != null) {
                queue.offer(cur.left);
            }

            if(cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }

    //判断完全二叉树
    boolean isCompleteTree(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            if(cur == null) {
                break;
            }
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        for (Node n :
                queue) {
            if (n != null) {
                return false;
            }
        }
        return true;
    }
}
