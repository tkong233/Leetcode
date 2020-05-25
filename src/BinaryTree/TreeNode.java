package BinaryTree;

public class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }

    /*
        return a example tree for convenient test purpose.
            0
           / \
          1   2
         / \   \
        3   4   5
           /
          6
     */
    public static TreeNode[] getExampleTree() {
        TreeNode t0 = new TreeNode(0);
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        t0.left = t1;
        t0.right = t2;
        t1.left = t3;
        t1.right = t4;
        t2.right = t5;
        t4.left = t6;
        return new TreeNode[] {t0, t1, t2, t3, t4, t5, t6};
    }
}