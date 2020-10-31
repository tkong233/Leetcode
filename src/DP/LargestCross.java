package DP;

public class LargestCross {
    int largestCross(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int[][] leftRight = new int[matrix.length][matrix[0].length];
        int[][] rightLeft = new int[matrix.length][matrix[0].length];
        int[][] topDown = new int[matrix.length][matrix[0].length];
        int[][] downTop = new int[matrix.length][matrix[0].length];

        // from left to right, top to down
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j == 0) {
                    leftRight[i][j] = matrix[i][j];
                } else if (i == 0) {
                    topDown[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 0) {
                    leftRight[i][j] = 0;
                    topDown[i][j] = 0;
                } else {
                    leftRight[i][j] = leftRight[i][j - 1] + 1;
                    topDown[i][j] = topDown[i - 1][j] + 1;
                }
            }
        }

        // from right to left, down to top
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                if (i == matrix.length - 1) {
                    downTop[i][j] = matrix[i][j];
                } else if (j == matrix[0].length - 1) {
                    rightLeft[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 0) {
                    downTop[i][j] = 0;
                    rightLeft[i][j] = 0;
                } else {
                    downTop[i][j] = downTop[i + 1][j] + 1;
                    rightLeft[i][j] = rightLeft[i][j + 1] + 1;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int min = min(leftRight[i][j], rightLeft[i][j], topDown[i][j], downTop[i][j]);
                result = Math.max(min, result);
            }
        }

        return result;
    }

    private int min(int a, int b, int c, int d) {
        int min = Math.min(a, b);
        min = Math.min(min, c);
        min = Math.min(min, d);

        return min;
    }

    public static void main(String[] args) {
        LargestCross solution = new LargestCross();
        int result = solution.largestCross(new int[][] {
                {
                    0, 1, 1, 0, 0
                },
                {
                    1, 1, 1, 1, 0
                },
                {
                    1, 1, 1, 1, 1
                },
                {
                    0, 1, 1, 0, 0
                },
                {
                    0, 0, 1, 0, 0
                }
        });
        System.out.println(result);
    }
}
