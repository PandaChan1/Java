package BinaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTest {
    public static Node reCreateTreeWithPreAndIn(char[] pre,char[] in) {
    if (pre.length == 0 || in.length == 0) return null;
    Node root = new Node(pre[0]);
        for (int i = 0; i < in.length; i++) {
            if (pre[0] == in[i]) {
                root.left = reCreateTreeWithPreAndIn(Arrays.copyOfRange(pre,1,i + 1),Arrays.copyOfRange(in,0,i));
                root.right = reCreateTreeWithPreAndIn(Arrays.copyOfRange(pre,i + 1,pre.length),Arrays.copyOfRange(in,i + 1,in.length));
            }
        }
        return root;
    }
    public static Node reCreateTreeWitchInAndPost(char[] post,char[] in) {
        if (post.length == 0 || in.length == 0) return null;
        Node root = new Node(post[post.length - 1]);
        for (int i = 0; i < in.length; i++) {
            if (post[post.length - 1] == in[i]) {
                root.left = reCreateTreeWitchInAndPost(Arrays.copyOfRange(post,0,i),Arrays.copyOfRange(in,0,i ));
                root.right = reCreateTreeWitchInAndPost(Arrays.copyOfRange(post,i,post.length - 1),Arrays.copyOfRange(in,i + 1,in.length));
            }
        }
        return root;
    }
public static Node reCreateTreeWithLevel(Character[] level) {
        if (level.length == 0) return null;
        Node root = new Node(level[0]);
        int i = 1;

       Queue<Node> queue = new LinkedList<Node>();
       queue.offer(root);

    while(i < level.length) {

        Node cur = queue.poll();
        Character temp = level[i++];


        if (temp != null ) {
        Node node = new Node(temp);
        cur.left = node;
        queue.offer(node);
        }

        temp = level[i++];

        if (temp != null) {
            Node node = new Node(temp);
            cur.right = node;
            queue.offer(node);
        }

    }
    return root;
}
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Node root = tree.createTree();
        System.out.println("前序");
        tree.preOrderTraversal(root);
        System.out.println();
//        tree.preorderTraversalNor(root);
//        System.out.println();
//        System.out.println("中序");
//        tree.inOrderTraversal(root);
//        System.out.println();
//        tree.inorderTraversalNor(root);
//        System.out.println();
//        System.out.println("后序");
//        tree.postOrderTraversal(root);
//        System.out.println();
//        tree.postorderTraversalNor(root);
//        System.out.println("重建树");
//        Node node = reCreateTreeWithPreAndIn(new char[]{'A', 'B', 'D', 'E', 'C', 'F'}, new char[]{'D', 'B', 'E', 'A', 'F', 'C'});
//        tree.preOrderTraversal(node);
//        System.out.println("重建树");
//        Node node1 = reCreateTreeWitchInAndPost(new char[]{'D','E','B','F','C','A'},new char[]{'D', 'B', 'E', 'A', 'F', 'C'});
//        tree.preOrderTraversal(node1);
//        System.out.println();
//        System.out.println("==========================");
//        System.out.println("节点个数");
//        System.out.println(tree.getSize(root));
//        tree.size(root);
//        System.out.println(BinaryTree.size);
//        System.out.println("叶子节点");
//        System.out.println(tree.getLeafSize(root));
//        tree.getLeaf(root);
//        System.out.println(BinaryTree.leaves);
//        System.out.println("高度");
//        System.out.println(tree.height(root));
//        System.out.println("找到给定值值所在的节点");
//        try {
//            System.out.println(tree.find(root, 'E').val);
//        }catch (NullPointerException e) {
//            e.printStackTrace();
//        }
        System.out.println("重建树");
        Node node2 = reCreateTreeWithLevel(new Character[]{'A', 'B', 'C', 'D', 'E', 'F',null});
        tree.levelOrderTraversal(node2);
//        System.out.println("层序遍历");
//        tree.levelOrderTraversal(root);
//        System.out.println();
//        System.out.println("判断完全二叉树");
//        System.out.println(tree.isCompleteTree(root));

    }
}
