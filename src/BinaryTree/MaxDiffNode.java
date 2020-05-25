package BinaryTree;

public class MaxDiffNode {
    /*
        Find the node with the max difference in the total number of descendents
        in its left subtree and right subtree.
     */

    TreeNode maxDiffNode(TreeNode root) {
        TreeNode[] maxNode = new TreeNode[] {null};
        maxDiffNodeHelper(root, new int[]{Integer.MIN_VALUE}, maxNode);
        return maxNode[0];
    }

    int maxDiffNodeHelper(TreeNode root, int[] globalMax, TreeNode[] solu) {
        if (root == null) {
            return 0;
        }
        int leftTotal = maxDiffNodeHelper(root.left, globalMax, solu);
        int rightTotal = maxDiffNodeHelper(root.right, globalMax, solu);
        int diff = Math.abs(leftTotal - rightTotal);
        if (diff > globalMax[0]) {
            globalMax[0] = diff;
            solu[0] = root;
        }
        return leftTotal + rightTotal + 1;
    }

    public static void main(String[] args) {
        MaxDiffNode solution = new MaxDiffNode();
        TreeNode[] tree = TreeNode.getExampleTree();
        TreeNode result = solution.maxDiffNode(tree[0]);
        System.out.println(result.value);
    }
}
