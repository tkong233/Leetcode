package BinaryTree;

public class LowestCommonAncestorI {
    /*
        return:
        null - there is no one or two in the tree.
        not null -
        1) if there is only one node one/two in the tree, just return the one/two itself.
        2) if both one and two are in the tree, return their LCA.
            a) one is two's descendant, return two.
            b) two is one's descendant, return one.
            c) return the lowest node with one and two in different subtrees.
     */
    TreeNode lcaI(TreeNode root, TreeNode one, TreeNode two) {
        if (root == null) {
            return null;
        }
        if (root == one || root == two) {
            return root;
        }
        TreeNode l = lcaI(root.left, one, two);
        TreeNode r = lcaI(root.right, one, two);
        if (l != null && r != null) {
            return root;
        }
        return l != null ? l : r;
    }

    public static void main(String[] args) {
        LowestCommonAncestorI solution = new LowestCommonAncestorI();
        TreeNode[] tree = TreeNode.getExampleTree();
        TreeNode result = solution.lcaI(tree[0], tree[3], tree[6]);
        System.out.println(result.value);
    }
}
