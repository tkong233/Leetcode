package NineChapters.BFS;

import BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        List<Integer> cur = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                cur.add(node.value);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(new LinkedList<Integer>(cur));
        }

        return result;
    }

    public static void main(String[] args) {
        LevelOrderTraversal solution = new LevelOrderTraversal();
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        one.left = two;
        one.right = three;

        List<List<Integer>> result = solution.levelOrder(one);
        for (List l : result) {
            for (Object o : l) {
                System.out.print(o + " ");
            }
            System.out.println();
        }


    }
}
