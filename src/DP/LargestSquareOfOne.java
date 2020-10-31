package DP;

public class LargestSquareOfOne {
    /*
        Determine the largest square of 1's in a binary matrix,
        return the length of the largest square.
     */

    int largestSqure(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int[][] largest = new int[matrix.length][matrix[0].length];
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 || j == 0) {
                    largest[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 1) {
                    largest[i][j] = Math.min(largest[i - 1][j] + 1, largest[i][j - 1] + 1);
                    largest[i][j] = Math.min(largest[i][j], largest[i - 1][j - 1] + 1);
                }
                result = Math.max(result, largest[i][j]);
            }
        }
        return result;
    }
}