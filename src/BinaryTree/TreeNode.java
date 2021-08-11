package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;

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

    // not working yet
    // [1,2,3,4,5,null,null,null,6,7]
    public static TreeNode fromArray(Integer[] array) {
        if (array == null || array.length == 0 || array[0] == null) {
            return null;
        }
        TreeNode[] nodes = new TreeNode[array.length];
        for (int i = 0; i < array.length; i++) {
            nodes[i] = array[i] == null ? null : new TreeNode(array[i]);
        }
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = nodes[0];
        q.offer(root);
        int i = 1;
        while (i < array.length) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                TreeNode cur = q.poll();
                if (cur == null) {
                    i += 2;
                    continue;
                }
                if (i < array.length && array[i] != null) {
                    TreeNode left = new TreeNode(array[i]);
                    q.offer(left);
                    cur.left = left;
                    i++;
                } else {
                    q.offer(null);
                }

                if (i < array.length && array[i] != null) {
                    TreeNode right = new TreeNode(array[i]);
                    q.offer(right);
                    cur.right = right;
                    i++;
                } else {
                    q.offer(null);
                }
            }
        }
        return root;
    }

    @Override
    public String toString() {
        return this.value + "";
    }
}