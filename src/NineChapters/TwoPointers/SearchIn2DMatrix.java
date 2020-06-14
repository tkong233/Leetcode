package NineChapters.TwoPointers;

public class SearchIn2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int left = 0;
        int right = matrix.length * matrix[0].length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midNum = get(matrix, mid);
            if (midNum == target) {
                return true;
            } else if (midNum < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    int get(int[][] matrix, int index) {
        int row = index / matrix[0].length;
        int col = index % matrix[0].length;
        return matrix[row][col];
    }
}
