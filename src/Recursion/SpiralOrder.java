package Recursion;

import java.util.ArrayList;
import java.util.List;

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

    // recursive way
    public List<Integer> spiral(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        spiral(matrix, matrix.length, result, matrix.length - 1, 0);
        return result;
    }

    // recursive helper
    private void spiral(int[][] matrix, int n, List<Integer> result, int length, int offset) {
        if (length <= 0) {
            if (matrix.length % 2 != 0) {
                result.add(matrix[offset][offset]);
            }
            return;
        }
        // up
        for (int i = 0; i < length; i++) {
            result.add(matrix[offset][offset + i]);
        }
        // right
        for (int i = 0; i < length; i++) {
            result.add(matrix[offset + i][n - offset - 1]);
        }
        // down
        for (int i = 0; i < length; i++) {
            result.add(matrix[n - offset - 1][n - offset - 1 - i]);
        }
        // left
        for (int i = 0; i < length; i++) {
            result.add(matrix[n - offset - 1 - i][offset]);
        }
        spiral(matrix, n, result, length - 2, offset + 1);
    }

    public static void main(String[] args) {
        int[][] a = new int[][] {
                {0, 1, 2, 3},
                {4, 5, 6, 7},
                {8, 9, 10, 11},
                {12, 13, 14, 15}
        };
        int[][] b = new int[][] {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8},
        };
        SpiralOrder solution = new SpiralOrder();
        List<Integer> result = solution.spiral(b);

        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
