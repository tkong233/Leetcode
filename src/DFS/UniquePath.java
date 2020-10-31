package DFS;

import java.util.LinkedList;
import java.util.Queue;

public class UniquePath {
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }

        int[][] memo = new int[m][n];
        for (int i = 0; i < n; i++) {
            memo[0][i] = 1;
        }

        for (int i = 0; i < m; i++) {
            memo[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                memo[i][j] = memo[i - 1][j] + memo[i][j - 1];
            }
        }

        return memo[m - 1][n - 1];
    }


    public static void main(String[] args) {
        UniquePath solution = new UniquePath();
        int result = solution.uniquePaths(1, 3);
        System.out.println(result);
    }
}
