package CodeSignal;

public class RotateMatrix {
    static int[][] rotateMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[rows][cols];
        for (int oldRow = 0; oldRow < rows; oldRow++) {
            for (int oldCol = 0; oldCol < cols; oldCol++) {
                if (oldRow == oldCol || oldCol == rows - oldRow - 1) {
                    result[oldRow][oldCol] = matrix[oldRow][oldCol];
                    continue;
                }
                int newRow = oldCol;
                int newCol = rows - oldRow - 1;
                result[newRow][newCol] = matrix[oldRow][oldCol];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {0, 1, 2, 3},
                {4, 5, 6, 7},
                {8, 9, 10, 11},
                {12, 13, 14, 15},
        };
        rotateMatrix(matrix);
    }
}
