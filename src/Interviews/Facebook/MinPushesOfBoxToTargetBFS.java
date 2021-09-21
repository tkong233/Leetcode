package Interviews.Facebook;

import java.util.*;
/*
Unfinished
 */
public class MinPushesOfBoxToTargetBFS {
    static int[] rowDirection = new int[] {-1, 1, 0, 0};
    static int[] colDirection = new int[] {0, 0, -1, 1};
    public int minPushBox(char[][] grid) {
        int steps = 0;
        Set<List<Integer>> visited = new HashSet<>();
        List<Integer> curState = getState(grid); // Sx, Sy, Bx, By
        visited.add(curState);
        List<Integer> target = getTarget(grid);
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(curState);
        int result = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                curState = queue.poll();
                for (int i = 0; i < 4; i++) {
                    List<Integer> nextState = getNextState(grid, visited, curState, rowDirection[i], colDirection[i]);
                    int action = -1;
                    if (nextState != null) {
                        action = nextState.get(4);
                    }
                    if (nextState == null) {
                        continue;
                    } else if (nextState.get(2) == target.get(0) && nextState.get(3) == target.get(1)) {
                        return steps;
                    } else {
                        if (action == 0) {
                            steps++; // 每条path的step可能不同， 不能只用一个global step
                        }
                        visited.add(nextState);
                        queue.offer(nextState);
                    }
                }
            }
        }
        return -1;
    }

    private List<Integer> getNextState(char[][] grid, Set<List<Integer>> visited, List<Integer> curState, int rowOffset, int colOffset) {
        int rowS = curState.get(0);
        int colS = curState.get(1);
        int rowB = curState.get(2);
        int colB = curState.get(3);
        int newRowS = rowS + rowOffset;
        int newColS = colS + colOffset;
        int newRowB = rowB + rowOffset;
        int newColB = colB + colOffset;
        List<Integer> nextState;
        // case 1: out of bound
        if (newRowS < 0 || newRowS >= grid.length || newColS < 0 || newColS >= grid[0].length) {
            return null;
        }
        // case 2: new pos is obstacle
        if (grid[newRowS][newColS] == '#') {
            return null;
        }
        // case 3: new pos is box
        if (newRowS == rowB && newColS == colB) {
            // case 4.1: new pos is B and B next to floor
            nextState = new ArrayList(Arrays.asList(newRowS, newColS, newRowB, newColB, 0));
            if (grid[newRowB][newColB] == '.' && !visited.contains(nextState)) {
                return nextState;
            } else {
                // case 4.2: B next to obstacle
                return null;
            }
        }
        // case 4: new pos is floor
        nextState = new ArrayList(Arrays.asList(newRowS, newColS, rowB, colB, 1));
        return visited.contains(nextState) ? null : nextState;
    }

    private List<Integer> getState(char[][] grid) {
        List<Integer> state = new ArrayList<>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 'S') {
                    grid[row][col] = '.';
                    state.add(0, col);
                    state.add(0, row);
                }
                if (grid[row][col] == 'B') {
                    grid[row][col] = '.';
                    state.add(row);
                    state.add(col);
                }
            }
        }
        return state;
    }

    private List<Integer> getTarget(char[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 'T') {
                    grid[row][col] = '.';
                    return Arrays.asList(row, col);
                }
            }
        }
        return null;
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

        MinPushesOfBoxToTargetBFS solution = new MinPushesOfBoxToTargetBFS();
        int res = solution.minPushBox(grid);
        System.out.println(res);
    }
}
