package CodeSignal;
import java.util.*;

public class SortChessBoardByQuery {
    private static void sort(int[][] board, int[][] queries) {
        for (int i = 0; i < queries.length; i++) {
            sortByQuery(board, queries[i][0], queries[i][1], queries[i][2]);
        }
    }

    private static void sortByQuery(int[][] board, int x, int y, int w) {
        List<Integer> white = new ArrayList<>();
        List<Integer> black = new ArrayList<>();
        for (int row = x; row < x + w; row++) {
            for (int col = y; col < y + w; col++) {
                if (row % 2 == col % 2) {
                    black.add(board[row][col]);
                } else {
                    white.add(board[row][col]);
                }
            }
        }

        Collections.sort(white);
        Collections.sort(black);
        int i = 0;
        int j = 0;
        for (int row = x; row < x + w; row++) {
            for (int col = y; col < y + w; col++) {
                if (row % 2 == col % 2) {
                    board[row][col] = black.get(j);
                    j++;
                } else {
                    board[row][col] = white.get(i);
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] board = new int[][] {
                {0, 1, 2, 3, 4},
                {5, 6, 7, 8, 9},
                {10, 13, 11, 12, 14},
                {15, 20, 1, 4, 19},
                {20, 21, 20, 19, 24}
        };
        int[][] queries = new int[][] {
                {2, 1, 3},
        };
        sort(board, queries);
    }
}
