package Interviews.Facebook;

import java.util.*;
/*
Correct but TLE
 */
public class MinPushesOfBoxToTargetDFS {
    static int[] rowDirection = new int[] {-1, 1, 0, 0};
    static int[] colDirection = new int[] {0, 0, -1, 1};

    public int minPushBox(char[][] grid) {
        // find target pos, init S pos
        List<Integer> state = Arrays.asList(0, 0, 0, 0);
        int[] target = new int[2];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 'S') {
                    state.set(0, row);
                    state.set(1, col);
                    grid[row][col] = '.';
                } else if (grid[row][col] == 'T') {
                    target[0] = row;
                    target[1] = col;
                    grid[row][col] = '.';
                } else if (grid[row][col] == 'B') {
                    state.set(2, row);
                    state.set(3, col);
                    grid[row][col] = '.';
                }
            }
        }
        int[] minPush = new int[] {Integer.MAX_VALUE};
        Set<List<Integer>> visited = new HashSet<>();
        minPushHelper(grid, visited, state, target, 0, minPush);

        return minPush[0] == Integer.MAX_VALUE ? -1 : minPush[0];
    }

    private void minPushHelper(char[][] grid, Set<List<Integer>> visited, List<Integer> state,
                               int[] target, int push, int[] minPush) {
        if (state.get(2) == target[0] && state.get(3) == target[1]) {
            minPush[0] = Math.min(minPush[0], push);
            return;
        }
        if (push >= minPush[0]) {
            return;
        }
        for (int i = 0; i < 4; i++) {
            int newSRow = state.get(0) + rowDirection[i];
            int newSCol = state.get(1) + colDirection[i];
            int newBRow = state.get(2) + rowDirection[i];
            int newBCol = state.get(3) + colDirection[i];
            // case 1: out of bound or meet obstacle
            if (!isInBound(grid, newSRow, newSCol) || grid[newSRow][newSCol] == '#') {
                continue;
            }
            // case 2: push box
            if (newSRow == state.get(2) && newSCol == state.get(3) && isInBound(grid, newBRow, newBCol) && grid[newBRow][newBCol] == '.') {
                List<Integer> nextState = Arrays.asList(newSRow, newSCol, newBRow, newBCol);
                if (!visited.contains(nextState)) {
                    visited.add(state);
                    minPushHelper(grid, visited, nextState, target, push + 1, minPush);
                    visited.remove(state);
                }
            } else if (grid[newSRow][newSCol] == '.') {
                // case 3: mvoe to floor
                List<Integer> nextState = Arrays.asList(newSRow, newSCol, state.get(2), state.get(3));
                if (!visited.contains(nextState)) {
                    visited.add(state);
                    minPushHelper(grid, visited, nextState, target, push, minPush);
                    visited.remove(state);
                }
            }
        }
    }

    private boolean isInBound(char[][] grid, int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }
    public static void main(String[] args) {
        String[][] stringGrid = new String[][] {
                {"#","#","#","#","#","#"},
                {"#","T","#","#","#","#"},
                {"#",".",".","B",".","#"},
                {"#",".","#","#",".","#"},
                {"#",".",".",".","S","#"},
                {"#","#","#","#","#","#"}
        };
        char[][] grid = new char[stringGrid.length][stringGrid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = stringGrid[i][j].charAt(0);
            }
        }

        for (char[] g : grid) {
            System.out.println(Arrays.toString(g));
        }

        MinPushesOfBoxToTargetDFS solution = new MinPushesOfBoxToTargetDFS();
        int res = solution.minPushBox(grid);
        System.out.println(res);
    }
}
