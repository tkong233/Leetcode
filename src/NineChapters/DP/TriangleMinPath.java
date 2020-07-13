package NineChapters.DP;

public class TriangleMinPath {
    public int minimumTotal(int[][] triangle) {
        if (triangle == null || triangle.length == 0 || triangle[0].length == 0) {
            return 0;
        }

        int[][] memo = new int[triangle.length][triangle.length];
        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0; j < triangle.length; j++) {
                memo[i][j] = Integer.MAX_VALUE;
            }
        }

        return helper(triangle, 0, 0, memo);
    }

    int helper(int[][] triangle,
               int row,
               int col,
               int[][] memo) {
        if (row == triangle.length) {
            return 0;
        }
        if (memo[row][col] != Integer.MAX_VALUE) {
            return memo[row][col];
        }

        int left = helper(triangle, row + 1, col, memo);
        int right = helper(triangle, row + 1, col + 1, memo);

        memo[row][col] = Math.min(left, right) + triangle[row][col];

        return memo[row][col];
    }

    public static void main(String[] args) {
        TriangleMinPath solution  = new TriangleMinPath();
        int[][] triangle = new int[][]{
                {1},
                {2, 3}
        };
        int result = solution.minimumTotal(triangle);
        System.out.println(result);
    }
}
