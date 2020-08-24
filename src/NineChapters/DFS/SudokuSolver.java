package NineChapters.DFS;

public class SudokuSolver {
    public void solveSudoku(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        dfs(board, 0);
    }

    void dfs(int[][] board,
             int index) {
        if (index == board.length * board[0].length) {
            printBoard(board);
            return;
        }

        int row = index / board[0].length;
        int col = index % board[0].length;

        if (board[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (isValid(board, i, row, col)) {
                    board[row][col] = i;
                    dfs(board, index + 1);
                    board[row][col] = 0;
                }
            }
        } else {
            dfs(board, index + 1);
        }
    }

    boolean isValid(int[][] board, int fill, int row, int col) {
        for (int i = 0; i < board[0].length; i++) {
            if (board[row][i] == fill) {
                return false;
            }
        }

        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == fill) {
                return false;
            }
        }

        int topLeftRow = row / 3 * 3;
        int topLeftCol = col / 3 * 3;

        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                int cur = board[topLeftRow + i][topLeftCol + j];
                if (cur == fill) {
                    return false;
                }
            }
        }

        return true;
    }

    void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SudokuSolver solution = new SudokuSolver();
        int[][] board = new int[][]  {
                new int[] {0,0,9,7,4,8,0,0,0},
                new int[] {7,0,0,0,0,0,0,0,0},
                new int[] {0,2,0,1,0,9,0,0,0},
                new int[] {0,0,7,0,0,0,2,4,0},
                new int[] {0,6,4,0,1,0,5,9,0},
                new int[] {0,9,8,0,0,0,3,0,0},
                new int[] {0,0,0,8,0,3,0,2,0},
                new int[] {0,0,0,0,0,0,0,0,6},
                new int[] {0,0,0,2,7,5,9,0,0}
        };
        solution.solveSudoku(board);
    }
}
