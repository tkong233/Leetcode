package BinaryTree;

import java.util.ArrayDeque;
import java.util.Deque;

public class TreeInorderIterator {
    Deque<TreeNode> stack;

    // constructor
    public TreeInorderIterator(TreeNode root) {
        this.stack = new ArrayDeque<>();
        this.traverseLeft(root);
    }

    private void traverseLeft(TreeNode root) {
        while (root != null) {
            this.stack.offerFirst(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode topNode = this.stack.pollFirst();
        if (topNode.right != null) {
            this.traverseLeft(topNode.right);
        }
        return topNode.value;
    }

    public boolean hasNext() {
        return this.stack.size() > 0;
    }
}
