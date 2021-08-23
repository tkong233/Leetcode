package BinaryTree;

public class LCAWithParent {
     public class TreeNodeP {
         public int key;
         public TreeNodeP left;
         public TreeNodeP right;
         public TreeNodeP parent;
         public TreeNodeP(int key, TreeNodeP parent) {
            this.key = key;
            this.parent = parent;
         }
     }

     TreeNodeP one;
     TreeNodeP two;

     public LCAWithParent() {
         TreeNodeP n1 = new TreeNodeP(1, null);
         TreeNodeP n2 = new TreeNodeP(2, n1);
         TreeNodeP n3 = new TreeNodeP(3, n1);
         TreeNodeP n4 = new TreeNodeP(4, n3);
         this.one = n3;
         this.two = n4;
     }

    public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
        int oneHeight = getHeight(one);
        int twoHeight = getHeight(two);
        if (oneHeight > twoHeight) {
            one = goAbove(one, oneHeight - twoHeight);
        } else {
            two = goAbove(two, twoHeight - oneHeight);
        }
        while (one != two) {
            one = one.parent;
            two = two.parent;
        }
        System.out.println(one.key);
        return one;
    }

    private int getHeight(TreeNodeP node) {
        int height = 0;
        while (node.parent != null) {
            node = node.parent;
            height++;
        }
        return height;
    }

    private TreeNodeP goAbove(TreeNodeP node, int height) {
        while (height > 0) {
            node = node.parent;
            height -= 1;
        }
        return node;
    }

    public static void main(String[] args) {
        LCAWithParent solution = new LCAWithParent();
        solution.lowestCommonAncestor(solution.one, solution.two);
    }
}
