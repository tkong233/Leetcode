package BinaryTree;
/*
    Given a binary tree, count the number of nodes in each node's left subtree,
    and store it in the numNodesLeft field.
 */

public class LeftTotal {
    static class TreeNodeLeft {
        int key;
        TreeNodeLeft left;
        TreeNodeLeft right;
        int numNodesLeft;

        public TreeNodeLeft(int key) {
            this.key = key;
        }
    }

    public void numNodesLeft(TreeNodeLeft root) {
        numNodes(root);
    }

    private int numNodes(TreeNodeLeft root) {
        if (root == null) {
            return 0;
        }
        int leftNum = numNodes(root.left);
        int rightNum = numNodes(root.right);
        root.numNodesLeft = leftNum;
        return leftNum + rightNum + 1;
    }


}
