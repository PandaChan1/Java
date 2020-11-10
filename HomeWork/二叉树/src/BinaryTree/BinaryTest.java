package BinaryTree;

public class BinaryTest {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Node root = tree.createTree();
        System.out.println("前序");
        tree.preOrderTraversal(root);
        System.out.println();
        tree.preorderTraversalNor(root);
        System.out.println();
        System.out.println("中序");
        tree.inOrderTraversal(root);
        System.out.println();
        tree.inorderTraversalNor(root);
        System.out.println();
        System.out.println("后序");
        tree.postOrderTraversal(root);
        System.out.println();
        tree.postorderTraversalNor(root);
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
//
//        System.out.println("层序遍历");
//        tree.levelOrderTraversal(root);
//        System.out.println();
//        System.out.println("判断完全二叉树");
//        System.out.println(tree.isCompleteTree(root));

    }
}
