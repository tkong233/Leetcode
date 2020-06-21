package NineChapters.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import BinaryTree.TreeNode;
import com.sun.source.tree.BinaryTree;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }

        List<String> leftPaths = binaryTreePaths(root.left);
        List<String> rightPaths = binaryTreePaths(root.right);
        for (String path : leftPaths) {
            paths.add(root.value + "->" + path);
        }
        for (String path : rightPaths) {
            paths.add(root.value + "->" + path);
        }

        // root is a leaf
        if (paths.size() == 0) {
            paths.add("" + root.value);
        }

        return paths;
    }

    public static void main(String[] args) {
        BinaryTreePaths solution = new BinaryTreePaths();
        TreeNode tree = TreeNode.getExampleTree()[0];
        List<String> result = solution.binaryTreePaths(tree);
        for (String s : result) {
            System.out.println(s);
        }

    }
}
