package BinaryTree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class InOrderIterative {
    public List<Integer> inOrder(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Deque<TreeNode> stk = new ArrayDeque<>();
        TreeNode cur = root;
        stk.offerFirst(root);
        while (cur != null || !stk.isEmpty()) {
            if (cur != null) {
                stk.offerFirst(cur.left);
                cur = cur.left;
            } else {
                TreeNode top = stk.pollFirst();
                result.add(top.value);
                cur = top.right;
            }
        }
        return result;
    }
}
