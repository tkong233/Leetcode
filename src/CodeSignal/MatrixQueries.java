package CodeSignal;
import java.util.*;

public class MatrixQueries {
    private static List<Integer> matrixQueries(int n, int m, List<List<Integer>> queries) {
        int[][] matrix = new int[n][m];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                matrix[row][col] = (row + 1) * (col + 1);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (List<Integer> query : queries) {
            if (query.size() == 1) {
                result.add(getMin(matrix));
            } else if (query.get(0) == 1) {
                deactivateRow(matrix, query.get(1));
            } else {
                deactivateCol(matrix, query.get(1));
            }
        }
        return result;
    }

    private static int getMin(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                min = Math.min(matrix[i][j], min);
            }
        }
        return min;
    }

    private static void deactivateRow(int[][] matrix, int row) {
        for (int col = 0; col < matrix[0].length; col++) {
            matrix[row - 1][col] = Integer.MAX_VALUE;
        }
    }

    private static void deactivateCol(int[][] matrix, int col) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row][col - 1] = Integer.MAX_VALUE;
        }
    }

    public static void main(String[] args) {
        matrixQueries(3, 4, Arrays.asList(Arrays.asList(0), Arrays.asList(1, 2), Arrays.asList(0), Arrays.asList(2, 1), Arrays.asList(0), Arrays.asList(1, 1), Arrays.asList(0)));
    }
}
