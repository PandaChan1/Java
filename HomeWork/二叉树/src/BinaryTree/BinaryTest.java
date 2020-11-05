package BinaryTree;

public class BinaryTest {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Node root = tree.createTree();
        tree.preOrderTraversal(root);
        System.out.println();
        tree.inOrderTraversal(root);
        System.out.println();
        tree.postOrderTraversal(root);
        System.out.println();
        System.out.println(tree.getSize(root));
        tree.size(root);
        System.out.println(BinaryTree.size);
        System.out.println(tree.getLeafSize(root));
        tree.getLeaf(root);
        System.out.println(BinaryTree.leaves);
    }
}
