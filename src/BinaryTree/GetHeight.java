package BinaryTree;

public class GetHeight {
    public static void main(String args[]) {
        TreeNode t1 = new TreeNode(0);
        t1.left = new TreeNode(1);
        t1.right = new TreeNode(2);

        GetHeight solution = new GetHeight();

        int h1 = solution.getHeight(t1);
        System.out.println(h1);

    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getHeight(root.left);
        int right = getHeight(root.right);
        int myHeight = 1 + Math.max(left, right);
        return myHeight;
    }
}
