package Recursion;

public class SpiralOrder {
    // iterative way
    void spiralOrder(int[][] a) {
        int l = 0;
        int n = a.length;
        while ((n - 2 * l) > 1) {
            // up
            for (int i = l; i <= (n - 2 - l); i++) {
                System.out.print(a[l][i] + " ");
            }
            // right
            for (int i = l; i <= (n - 2 - l); i++) {
                System.out.print(a[i][n - l - 1] + " ");
            }
            // down
            for (int i = (n - l - 1); i >= (l + 1); i--) {
                System.out.print(a[n - 1 - l][i] + " ");
            }
            // left
            for (int i = (n - l - 1); i >= (l + 1); i--) {
                System.out.print(a[i][l] + " ");
            }
            l++;
        }
        if ((n - 2 * l) == 1) {
            System.out.print(a[l][l]);
        }
    }

    public static void main(String[] args) {
        int[][] a = new int[][] {
                {0, 1, 2, 3},
                {4, 5, 6, 7},
                {8, 9, 10, 11},
                {12, 13, 14, 15}
        };
        SpiralOrder solution = new SpiralOrder();
        solution.spiralOrder(a);
    }
}
