package BinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.logging.Level;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        LevelOrderTraversal solution = new LevelOrderTraversal();
        TreeNode root = TreeNode.fromArray(new Integer[] {1,2,3,4,5,null,null,null,6,7});
        List<List<Integer>> result = solution.layerByLayer(root);
        for (List<Integer> l : result) {
            for (Integer i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> layerByLayer(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> curLevel = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                curLevel.add(cur.value);
            }
            result.add(curLevel);
            curLevel = new LinkedList<>();
        }
        return result;
    }
}
