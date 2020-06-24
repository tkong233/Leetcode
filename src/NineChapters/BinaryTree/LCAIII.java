package NineChapters.BinaryTree;

import javafx.scene.Parent;

import java.util.ArrayList;
import java.util.List;


public class LCAIII {


    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
        List<ParentTreeNode> pathA = new ArrayList<>();
        List<ParentTreeNode> pathB = new ArrayList<>();

        while (A != null) {
            pathA.add(A);
            A = A.parent;
        }
        while (B != null) {
            pathB.add(B);
            B = B.parent;
        }

        int idA = pathA.size() - 1;
        int idB = pathB.size() - 1;
        while (idA >= 0 && idB >= 0) {
            if (pathA.get(idA) != pathB.get(idB)) {
                break;
            }
            idA--;
            idB--;
        }

        return pathA.get(idA).parent;
    }

    public static void main(String[] args) {
        LCAIII solution = new LCAIII();

        ParentTreeNode t1 = new ParentTreeNode(1);
        ParentTreeNode t2 = new ParentTreeNode(2);
        ParentTreeNode t3 = new ParentTreeNode(3);
        ParentTreeNode t4 = new ParentTreeNode(4);
        ParentTreeNode t5 = new ParentTreeNode(5);
        t1.right = t2;
        t2.right = t3;
        t3.right = t4;
        t4.right = t5;
        t5.parent = t4;
        t4.parent = t3;
        t3.parent = t2;
        t2.parent = t1;

        ParentTreeNode result = solution.lowestCommonAncestorII(t1, t3, t5);
        System.out.println(result.val);


    }
}
