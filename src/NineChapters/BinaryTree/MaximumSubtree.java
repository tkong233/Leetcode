package NineChapters.BinaryTree;

import BinaryTree.TreeNode;

public class MaximumSubtree {
    public TreeNode findSubtree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode result = null;
        int[] max = new int[] {Integer.MIN_VALUE};
        helper(root, result, max);
        return result;
    }

    int helper(TreeNode root, TreeNode result, int[] max) {
        if (root == null) {
            return 0;
        }
        int leftSum = helper(root.left, result, max);
        int rightSum = helper(root.right, result, max);
        int curSum = leftSum + rightSum + root.value;
        if (curSum > max[0]) {
            max[0] = curSum;
            result = root;
        }
        return curSum;
    }

    public static void main(String[] args) {
        MaximumSubtree solution = new MaximumSubtree();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(-5);
        TreeNode t3 = new TreeNode(2);
        t1.left = t2;
        t1.right = t3;
        TreeNode result = solution.findSubtree(t1);
        if (result != null) {
            System.out.println(result);
        }
    }
}
