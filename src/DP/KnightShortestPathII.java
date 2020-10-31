package DP;

import NineChapters.BFS.KnightShortestPathI;

public class KnightShortestPathII {
    public int shortestPath2(boolean[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0
                || grid[0][0] || grid[grid.length - 1][grid[0].length - 1]) {
            return -1;
        }

        int[][] dp = new int[grid.length][grid[0].length];
        int[] xDirection = new int[] {1, -1, 2, -2};
        int[] yDirection =  new int[] {-2, -2, -1, -1};

        for (int row = 0; row < dp.length; row++) {
            for (int col = 0; col < dp[0].length; col++) {
                dp[row][col] = Integer.MAX_VALUE;
            }
        }

        dp[0][0] = 0;
        for (int row = 0; row < dp.length; row++) {
            for (int col = 0; col < dp[0].length; col++) {
                if (grid[row][col]) {
                    continue;
                }

                for (int i = 0; i < 4; i++) {
                    int x = row + xDirection[i];
                    int y = col + yDirection[i];

                    if (!isValid(x, y, grid)) {
                        continue;
                    }

                    if (dp[x][y] == Integer.MAX_VALUE) {
                        continue;
                    }

                    dp[x][y] = Math.min(dp[x][y] + 1, dp[row][col]);
                }
            }
        }

        if (dp[dp.length - 1][dp[0].length - 1] == Integer.MAX_VALUE) {
            return -1;
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }

    private boolean isValid(int x, int y, boolean[][] grid) {
        if (x < 0 || x > grid.length - 1 || y < 0 || y > grid[0].length - 1) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        KnightShortestPathII solution = new KnightShortestPathII();
        boolean[][] grid = new boolean[][] {
                {false, false, false, false},
                {false, false, false, false},
                {false, false, false, false}
        };

        int result = solution.shortestPath2(grid);
        System.out.println(result);
    }
}
